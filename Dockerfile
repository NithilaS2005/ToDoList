FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/ToDoList-1.0.jar ToDoList.jar
ENTRYPOINT ["java", "-jar", "ToDoList.jar"]
