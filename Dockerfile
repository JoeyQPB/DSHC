#FROM ubuntu:latest AS build
#
#RUN apt-get update && \
#    apt-get install -y openjdk-17-jdk maven
#
#COPY . .
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

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

COPY . .

RUN mvn clean install -DskipTests

FROM azul/zulu-openjdk:17

WORKDIR /app

COPY target/DSHC-1.0.0.jar /app/DSHC.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/DSHC.jar"]
