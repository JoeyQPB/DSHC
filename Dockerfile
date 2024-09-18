#FROM ubuntu:latest AS build
#
#RUN apt-get update
#RUN apt-get install openjdk-17-jdk -y
#
#COPY . .
#
#RUN apt-get install maven -y
#RUN mvn clean install -DskipTests
#
#FROM openjdk:17-jdk-slim
#
#EXPOSE 8080
#
#COPY --from=build target/DSHC-1.0.0.jar /app/DSHC.jar
#
#ENTRYPOINT ["java", "-jar", "/app/DSHC.jar"]

FROM ubuntu:latest AS build

# Atualiza o sistema e instala o OpenJDK
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

# Copia o código-fonte e constrói o projeto
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-slim

# Expõe a porta 8080
EXPOSE 8080

# Define as variáveis de ambiente
ENV SPRING_FLYWAY_URL=jdbc:postgres://dpg-crbp21d6l47c73d89qqg-a:5432
ENV SPRING_FLYWAY_USER=postgre
ENV SPRING_FLYWAY_PASSWORD=Tp5GkHx2dUKKqo1d2iVJLf9OxBaIEw4E

# Copia o JAR da imagem de build
COPY --from=build target/DSHC-1.0.0.jar /app/DSHC.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app/DSHC.jar"]
