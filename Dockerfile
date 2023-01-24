FROM adoptopenjdk/openjdk11

ARG JAR_FILE_PATH=build/lib/*.jar

COPY ${JAR_FILE_PATH} app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]