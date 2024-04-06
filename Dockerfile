FROM openjdk:17-jdk-alpine
COPY target/norus-0.0.1-SNAPSHOT.jar norus-1.0.0.jar
ENTRYPOINT [ "java", "-jar", "norus-1.0.0.jar" ]
