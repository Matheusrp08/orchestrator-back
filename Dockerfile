# Fase de build (com JDK + Maven)
FROM eclipse-temurin:17-jdk-jammy as builder

# Instale o Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Variáveis de ambiente
ENV SPRING_PROFILES_ACTIVE=prod \
    JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Diretório de trabalho
WORKDIR /app

# Copie todo o projeto primeiro (para resolver dependências corretamente)
COPY . .

# Instale dependências Maven
RUN mvn dependency:go-offline

# Build do JAR (sem testes)
RUN mvn package -DskipTests -Pprod

# Fase final (sem JDK, apenas JRE)
FROM eclipse-temurin:17-jre-jammy

# Copie o JAR gerado (verifique o nome exato do JAR)
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Exporte a porta
EXPOSE 8081

# Comando para executar
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
