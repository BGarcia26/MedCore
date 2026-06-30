# 1. Etapa de compilación
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 2. Etapa de ejecución (Con soporte gráfico y fuentes para Jasper)
FROM eclipse-temurin:17-jdk-alpine
# Instalamos los paquetes necesarios para que JasperReports renderice textos y PDFs
RUN apk add --no-cache fontconfig ttf-dejavu
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
# Ejecutamos en modo headless para servidores sin interfaz gráfica
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-jar", "app.jar"]