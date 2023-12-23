# DEFINE BASE DOCKER IMAGE

FROM openjdk:21
LABEL maintainer="Gideon Shawana"
ADD target/FinanceManagementSystem-0.0.1-SNAPSHOT.jar FinanceManagementSystem.jar
ENTRYPOINT ["java","-jar","FinanceManagementSystem.jar"]