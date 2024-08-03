# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory to the working directory in the container
COPY target/inquiryms.jar /app/inquiryms.jar

# Expose the port that the application runs on (update to 8081)
EXPOSE 8081

# Define the command to run the application
CMD ["java", "-jar", "inquiryms.jar"]


