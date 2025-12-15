package orchestrator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ExportFullArchitectureMain {

    private static final String BASE_PACKAGE = "orchestrator";
    private static final Path SOURCE_ROOT =
            Path.of("src/main/java");

    public static void main(String[] args) throws Exception {

        SpringApplication app =
                new SpringApplication(OrchestratorApplication.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);

        try (ConfigurableApplicationContext context = app.run()) {

            Map<String, Object> root = new LinkedHashMap<>();

            root.put("project", Map.of(
                    "name", "orchestrator",
                    "basePackage", BASE_PACKAGE
            ));

            Map<String, List<Object>> architecture =
                    new LinkedHashMap<>();

            architecture.put("controllers", new ArrayList<>());
            architecture.put("services", new ArrayList<>());
            architecture.put("repositories", new ArrayList<>());
            architecture.put("entities", new ArrayList<>());
            architecture.put("dtos", new ArrayList<>());
            architecture.put("others", new ArrayList<>());

            // 🔍 Varre todas as classes do contexto
            String[] beans = context.getBeanDefinitionNames();

            for (String beanName : beans) {
                Object bean = context.getBean(beanName);
                Class<?> clazz = bean.getClass();

                if (!clazz.getPackageName().startsWith(BASE_PACKAGE))
                    continue;

                Map<String, Object> classJson =
                        buildClassJson(clazz);

                if (clazz.isAnnotationPresent(RestController.class)) {
                    architecture.get("controllers").add(classJson);
                }
                else if (clazz.isAnnotationPresent(Service.class)) {
                    architecture.get("services").add(classJson);
                }
                else if (clazz.isAnnotationPresent(Repository.class)) {
                    architecture.get("repositories").add(classJson);
                }
                else if (clazz.isAnnotationPresent(Entity.class)) {
                    architecture.get("entities").add(classJson);
                }
                else if (clazz.getSimpleName().toLowerCase().contains("dto")) {
                    architecture.get("dtos").add(classJson);
                }
                else {
                    architecture.get("others").add(classJson);
                }
            }

            root.put("architecture", architecture);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            Path output = Path.of("full-backend-architecture.json");
            mapper.writeValue(output.toFile(), root);

            System.out.println("✔ Arquitetura completa exportada:");
            System.out.println(output.toAbsolutePath());
        }
    }

    // =========================
    // 🔧 Helpers
    // =========================

    private static Map<String, Object> buildClassJson(Class<?> clazz)
            throws IOException {

        Map<String, Object> json = new LinkedHashMap<>();

        json.put("package", clazz.getPackageName());
        json.put("className", clazz.getSimpleName());
        json.put("fullClassName", clazz.getName());

        // Anotações
        List<String> annotations = new ArrayList<>();
        for (Annotation a : clazz.getAnnotations()) {
            annotations.add(a.annotationType().getSimpleName());
        }
        json.put("annotations", annotations);

        // Métodos
        List<Map<String, String>> methods = new ArrayList<>();
        Arrays.stream(clazz.getDeclaredMethods()).forEach(m -> {
            Map<String, String> mJson = new LinkedHashMap<>();
            mJson.put("name", m.getName());
            mJson.put("returnType", m.getReturnType().getSimpleName());
            methods.add(mJson);
        });
        json.put("methods", methods);

        // Código-fonte
        json.put("sourceCode", readSourceCode(clazz));

        return json;
    }

    private static String readSourceCode(Class<?> clazz)
            throws IOException {

        String relativePath =
                clazz.getName().replace(".", "/") + ".java";

        Path sourceFile =
                SOURCE_ROOT.resolve(relativePath);

        if (Files.exists(sourceFile)) {
            return Files.readString(sourceFile);
        }
        return "<<SOURCE NOT FOUND>>";
    }
}
