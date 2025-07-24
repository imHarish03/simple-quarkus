# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the fat jar
COPY target/simple-quarkus-1.0.0-SNAPSHOT.jar app.jar

# Expose the Quarkus default port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
