# Use an official OpenJDK image as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the source code (including the Maven or Gradle build files) to the container
COPY . /app

# Build the application using Maven (adjust the command if you're using Gradle)
RUN ./mvnw clean package

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Define an environment variable to customize the Spring profile (if needed)
# ENV SPRING_PROFILES_ACTIVE=production

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "target/restaurant-0.0.1-SNAPSHOT.jar"]
