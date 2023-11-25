# Use an official OpenJDK image as a parent image
FROM openjdk:11-jre-slim AS runtime

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file from your local machine into the container
COPY target/restaurant-0.0.1-SNAPSHOT.jar ./restaurant.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 8080

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "restaurant.jar"]
