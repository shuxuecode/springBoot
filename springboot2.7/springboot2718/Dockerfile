FROM openjdk:11-jdk-slim
COPY target/*.jar /usr/app/app.jar
ENTRYPOINT ["java","-jar","/usr/app/app.jar"]