FROM openjdk:17-alpine3.14
WORKDIR /appl
COPY /target/findprofile-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
CMD ["java","-jar", "app.jar"]