FROM maven:latest
WORKDIR /app
COPY . .
CMD ["mvn", "spring-boot:run"]