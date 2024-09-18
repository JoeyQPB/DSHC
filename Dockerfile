FROM ubuntu:latest AS build

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -DskipTests

FROM azul/zulu-openjdk:17

EXPOSE 8080

COPY --from=build target/DSHC-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
