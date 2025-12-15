# Fase de build (com JDK + Maven)
FROM eclipse-temurin:17-jdk-jammy as builder

# Instale o Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copie todo o projeto
COPY . .

# Build do projeto
RUN mvn clean package -DskipTests -Pprod

# Fase final (apenas JRE)
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copie o JAR gerado
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081

# Defina as variáveis de ambiente para garantir que o servidor escuta em todas as interfaces
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -Dserver.address=0.0.0.0"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]

# Adicione esta linha ao final do Dockerfile
HEALTHCHECK --interval=30s --timeout=3s \
  CMD curl -f http://localhost:8081/actuator/health || exit 1
