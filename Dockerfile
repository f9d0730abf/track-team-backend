FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY TrackTeam.jar TrackTeam.jar
ENTRYPOINT ["java","-jar","/TrackTeam.jar"]
EXPOSE 8080
