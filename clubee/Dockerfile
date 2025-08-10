FROM maven:3.9.6 AS builder
WORKDIR /usr/src/app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests
RUN ls -l /usr/src/app/target
FROM openjdk:21
WORKDIR /usr/src/app
COPY --from=builder /usr/src/app/target/*.jar ./app.jar
EXPOSE 8080
CMD [ "java", "-jar", "app.jar" ]
