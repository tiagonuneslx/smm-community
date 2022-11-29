FROM gradle:7-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle shadowJar --no-daemon

FROM openjdk:11
EXPOSE 80:80
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/backend-1.0.0-alpha.1-all.jar /app/backend.jar
ENTRYPOINT ["java","-jar","/app/backend.jar"]