FROM amazoncorretto:17.0.7-al2023

COPY build/libs/thoughtsporadic-backend-1.0-all.jar .

CMD ["java", "-jar", "thoughtsporadic-backend-1.0-all.jar"]