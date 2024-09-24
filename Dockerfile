FROM ubuntu:latest AS build

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven
COPY . .

RUN apt-get install maven -y
RUN mvn clean install -DskipTests

FROM azul/zulu-openjdk:17

EXPOSE 8080

#ARG DATABASE_URL=jdbc:postgresql://dpg-crbp21d6l47c73d89qqg-a:5432/dshcdb
#ARG DATABASE_USERNAME=postgre
#ARG DATABASE_PASSWORD=Tp5GkHx2dUKKqo1d2iVJLf9OxBaIEw4E
#
#ARG DATABASE_URL_FLY=jdbc:postgresql://dpg-crbp21d6l47c73d89qqg-a:5432/dshcdb
#ARG DATABASE_USERNAME_FLY=postgre
#ARG DATABASE_PASSWORD_FLY=Tp5GkHx2dUKKqo1d2iVJLf9OxBaIEw4E
#
#ENV DATABASE_URL=${DATABASE_URL}
#ENV DATABASE_USERNAME=${DATABASE_USERNAME}
#ENV DATABASE_PASSWORD=${DATABASE_PASSWORD}
#
#ENV DATABASE_URL_FLY=${DATABASE_URL_FLY}
#ENV DATABASE_USERNAME_FLY=${DATABASE_USERNAME_FLY}
#ENV DATABASE_PASSWORD_FLY=${DATABASE_PASSWORD_FLY}

COPY --from=build target/DSHC-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]