FROM openjdk:8-jre-slim
WORKDIR /home
COPY /target/springbootdemo-1.0.0-SNAPSHOT.jar springbootdemo-1.0.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springbootdemo-1.0.0-SNAPSHOT.jar"]
