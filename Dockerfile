FROM openjdk:21
VOLUME /tmp
COPY ./target/arquitetura-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
CMD ["java", "-jar", "arquitetura-0.0.1-SNAPSHOT.jar"]