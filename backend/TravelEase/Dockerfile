FROM openjdk:11
ARG WAR_FILE=/backend/TravelEase/target/*.war
COPY /backend/TravelEase/target/TravelEase-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java", "-jar","app.war"]