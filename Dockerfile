FROM openjdk:9-jdk
EXPOSE 8081
ADD /target/spring-boot-elasticsearch-0.0.1-SNAPSHOT.jar  spring-boot-elasticsearch-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-boot-elasticsearch-0.0.1-SNAPSHOT.jar"]