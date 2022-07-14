FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} app3.jar
ENTRYPOINT ["java","-jar","app3.jar"]