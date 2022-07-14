FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} app1.jar
ENTRYPOINT ["java","-jar","app1.jar"]