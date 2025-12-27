# Этап сборки: собираем весь проект
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/order-service/target/order-service-*.jar order-service.jar
COPY --from=build /app/payment-service/target/payment-service-*.jar payment-service.jar
