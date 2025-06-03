FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/prometheus-demo-1.0-SNAPSHOT-shaded.jar app.jar

EXPOSE 9091

ENTRYPOINT ["java", "-jar", "app.jar"]
