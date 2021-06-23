
FROM openjdk:11
EXPOSE 8003
ADD ./target/rpm-vendor-microservice.jar rpm-vendor-microservice.jar
ENTRYPOINT ["java","-jar","rpm-vendor-microservice.jar"]