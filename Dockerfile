FROM maven:ibmjava-alpine
WORKDIR /spring-app
COPY . .
RUN mvn clean package
