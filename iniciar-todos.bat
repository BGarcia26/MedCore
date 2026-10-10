@echo off
echo Iniciando Muestra Reducida para el Video...

:: Forzamos Java 21 
set JAVA_HOME=C:\Program Files\Java\jdk-21
set PATH=%JAVA_HOME%\bin;%PATH%

:: 1. Eureka
start "ms-eureka" cmd /k "cd eureka && gradlew bootRun"
timeout /t 15 /nobreak >nul

:: 2. Solo dos microservicios clave
start "ms-insumos" cmd /k "cd ms-insumos && mvnw spring-boot:run"
start "ms-usuarios" cmd /k "cd ms-usuarios && mvnw spring-boot:run"
timeout /t 10 /nobreak >nul

:: 3. Gateway
start "ms-gateway" cmd /k "cd ms-gateway && mvnw spring-boot:run"

echo Muestra lista. Abre Postman y ataca a http://localhost:8080