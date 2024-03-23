FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/midterm-0.0.1-SNAPSHOT.jar Backend.jar
ENTRYPOINT ["java", "-jar", "Backend.jar"]
