# Backend Dockerfile
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the build files to the container
COPY build/libs/*.jar app.jar

# Expose the backend service port
EXPOSE 8080

# Run the backend application
ENTRYPOINT ["java", "-jar", "app.jar"]
