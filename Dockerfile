# Fase de build (com JDK + Maven)
FROM eclipse-temurin:17-jdk-jammy as builder

# Instale o Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Diretório de trabalho
WORKDIR /app

# Copie todo o projeto
COPY . .

# Build do JAR
RUN mvn clean package -DskipTests -Pprod

# Fase final (sem JDK, apenas JRE)
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copie o JAR gerado
COPY --from=builder /app/target/*.jar app.jar

# Exporte a porta
EXPOSE 8081

# Defina as variáveis de ambiente
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -Dserver.address=0.0.0.0"

# Comando para executar o JAR
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
