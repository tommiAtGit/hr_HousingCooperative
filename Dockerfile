FROM adoptopenjdk/openjdk14:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=target/housingCooperative-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","app.jar"]

HEALTHCHECK CMD curl --fail http://localhost:8090/api/hc_housigCooperative/health || exit 1

CMD java -jar /opt/app/app.jar
