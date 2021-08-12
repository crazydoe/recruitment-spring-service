FROM adoptopenjdk/openjdk11:ubi
VOLUME /main-app
ADD target/simpleCrudApplication-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]