# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the Quarkus application (not just a single jar)
COPY target/quarkus-app/ /app

# Expose the Quarkus default port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "quarkus-run.jar"]
