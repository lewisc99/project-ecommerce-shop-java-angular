FROM openjdk:11
RUN apt-get update -y
RUN apt-get upgrade -y
RUN apt-get install -y maven
EXPOSE 8080
COPY ./ ./
RUN mvn clean package

CMD ["java","-jar","target/13-springboot-jpa-h2-test.jar"]
