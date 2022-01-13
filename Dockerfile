
FROM openjdk:latest AS builder
COPY ./target/bbw_test-0.0.1-SNAPSHOT.jar /app/bbw_test.jar
CMD ["java","-jar","/app/bbw_test.jar"]
