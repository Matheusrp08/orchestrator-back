package orchestrator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ExportEndpointsMain {

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(OrchestratorApplication.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);

        try (ConfigurableApplicationContext context = app.run()) {

            RequestMappingHandlerMapping mapping =
                    context.getBean(RequestMappingHandlerMapping.class);

            Map<String, Object> controllersJson = new LinkedHashMap<>();

            for (Map.Entry<RequestMappingInfo, HandlerMethod> entry :
                    mapping.getHandlerMethods().entrySet()) {

                RequestMappingInfo info = entry.getKey();
                HandlerMethod handler = entry.getValue();

                Class<?> controllerClass = handler.getBeanType();
                String controllerName = controllerClass.getSimpleName();

                // Base path do controller
                String basePath = "";
                RequestMapping classMapping =
                        controllerClass.getAnnotation(RequestMapping.class);

                if (classMapping != null && classMapping.value().length > 0) {
                    basePath = classMapping.value()[0];
                }

                controllersJson.putIfAbsent(controllerName, new LinkedHashMap<>());
                Map<String, Object> controllerNode =
                        (Map<String, Object>) controllersJson.get(controllerName);

                controllerNode.putIfAbsent("basePath", basePath);
                controllerNode.putIfAbsent("endpoints", new ArrayList<>());

                List<Map<String, Object>> endpoints =
                        (List<Map<String, Object>>) controllerNode.get("endpoints");

                Map<String, Object> endpoint = new LinkedHashMap<>();

                endpoint.put("name", handler.getMethod().getName());
                endpoint.put("javaMethod", handler.getMethod().getName());
                endpoint.put("httpMethods", info.getMethodsCondition().getMethods());

                Set<String> paths =
                        info.getPathPatternsCondition() != null
                                ? info.getPathPatternsCondition().getPatternValues()
                                : info.getPatternsCondition().getPatterns();

                endpoint.put("path", paths);

                endpoints.add(endpoint);
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            String json = mapper.writeValueAsString(controllersJson);

            Path output = Path.of("controllers-endpoints.json");
            Files.writeString(output, json);

            System.out.println("✔ JSON gerado em: " + output.toAbsolutePath());
        }
    }
}
