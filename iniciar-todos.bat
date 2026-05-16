@echo off
echo Iniciando todos los microservicios MedCore...

set JAVA_HOME=C:\Program Files\Java\jdk-21
set PATH=%JAVA_HOME%\bin;%PATH%

start "ms-insumos"      cmd /k "cd ms-insumos && mvnw spring-boot:run"
timeout /t 3 /nobreak >nul
start "ms-usuarios"     cmd /k "cd ms-usuarios && mvnw spring-boot:run"
start "ms-categorias"   cmd /k "cd ms-categorias && mvnw spring-boot:run"
start "ms-lotes"        cmd /k "cd ms-lotes && mvnw spring-boot:run"
start "ms-movimientos"  cmd /k "cd ms-movimientos && mvnw spring-boot:run"
start "ms-mermas"       cmd /k "cd ms-mermas && mvnw spring-boot:run"
start "ms-episodios"    cmd /k "cd ms-episodios && mvnw spring-boot:run"
start "ms-alertas"      cmd /k "cd ms-alertas && mvnw spring-boot:run"
start "ms-reportes"     cmd /k "cd ms-reportes && mvnw spring-boot:run"
timeout /t 5 /nobreak >nul
start "ms-gateway"      cmd /k "cd ms-gateway && mvnw spring-boot:run"

echo Todos los servicios iniciados. Gateway en http://localhost:8080