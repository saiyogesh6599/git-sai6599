# Set the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the local system to the working directory in the container
COPY target/uberApp-0.0.1-SNAPSHOT.jar /app/uberApp.jar

# Expose port for the container (optional)
EXPOSE 8080

# Command to run the JAR file
CMD ["java", "-jar", "uberApp.jar"]
