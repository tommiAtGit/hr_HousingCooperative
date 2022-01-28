FROM adoptopenjdk/openjdk14:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=target/housingRecord-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]