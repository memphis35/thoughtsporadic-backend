FROM amazoncorretto:17.0.7-al2023

WORKDIR /app

COPY build/libs/ts-be-1.0-all.jar .

ENTRYPOINT ["java", "-jar", "/app/ts-be-1.0-all.jar"]