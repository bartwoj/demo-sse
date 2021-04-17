FROM maven:3-openjdk-14 AS build
RUN mkdir /usr/src/project
COPY . /usr/src/project
WORKDIR /usr/src/project
RUN mvn clean package -DskipTests

FROM openjdk:14-jdk-alpine
RUN mkdir /project
COPY --from=build /usr/src/project/target/demo-sse-0.0.1-SNAPSHOT.jar /project/
WORKDIR /project
CMD java -jar demo-sse-0.0.1-SNAPSHOT.jar