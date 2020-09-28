FROM openjdk:8-slim

MAINTAINER chengfei chengfei001@gmail.com

ADD target/*.jar /opt/eureka.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "-Dserver.port=8761", "/opt/eureka.jar"]