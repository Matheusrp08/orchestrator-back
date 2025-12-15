# Use a imagem oficial do OpenJDK 17 (recomendado para Spring Boot 3.x)
FROM eclipse-temurin:17-jdk-jammy as builder

# Defina variáveis de ambiente
ENV SPRING_PROFILES_ACTIVE=prod \
    JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Diretório de trabalho
WORKDIR /app

# Copie o arquivo de build (pom.xml ou build.gradle)
COPY pom.xml .
COPY gradlew .
COPY gradle gradle
COPY settings.gradle .
COPY build.gradle .

# Instale dependências
RUN ./gradlew dependencies --no-daemon

# Copie o restante do projeto
COPY src ./src

# Build do projeto
RUN ./gradlew bootJar --no-daemon

# Use uma imagem mais leve para execução
FROM eclipse-temurin:17-jre-jammy

# Copie o JAR compilado da fase de build
COPY --from=builder /app/build/libs/*.jar app.jar

# Exporte a porta do Spring Boot
EXPOSE 8081

# Comando para executar o JAR
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]