Descripcion:
MedCore es un ecosistema de microservicios diseñado para la gestión integral de un centro médico u hospitalario. El sistema permite administrar de forma modular procesos críticos como: inventario de insumos, gestión de usuarios, categorías, control de lotes, movimientos, mermas, episodios clínicos, alertas y reportes. La arquitectura busca el desacoplamiento de los módulos para garantizar escalabilidad y mantenimiento eficiente mediante Spring Boot, Eureka para el descubrimiento de servicios y un API Gateway para la gestión centralizada de peticiones.

Estudiantes:
-Benjamín García
-Nicolas Lara

Listado de Microservicios:
Servicio    ,   Puerto  ,    Descripción
ms-gateway  ,   8080    ,   Punto único de entrada (API Gateway).
ms-insumos  ,   8081    ,   Gestión y stock de insumos médicos.
ms-usuarios ,   8082    ,   Gestión de personal y pacientes.
ms-categorias,  8083    ,   Clasificación de los recursos.
ms-lotes    ,   8084    ,   Control de lotes de productos.
ms-movimientos, 8085    ,   Registro de entradas y salidas.
ms-mermas   ,   8086    ,   Gestión de pérdidas y vencimientos.
ms-episodios,   8087    ,   Registro de atenciones clínicas.
ms-alertas,     8088    ,   Notificaciones de stock bajo o vencimientos.
ms-reportes,    8089    ,   Generación de informes (JasperReports).
ms-eureka,      8761    ,   Servidor de descubrimiento de servicios.

URL:
ms-gateway:https://ms-gateway-8h9r.onrender.com/
ms-eureka:https://eureka-etr2.onrender.com/
Insumos:https://ms-insumos.onrender.com/swagger-ui/index.html
Usuarios:https://ms-usuarios-0tqx.onrender.com/swagger-ui/index.html
Categorias:https://ms-categorias-2ac1.onrender.com/swagger-ui/index.html
Lotes:https://ms-lotes.onrender.com/swagger-ui/index.html
Movimientos:https://ms-movimientos.onrender.com/swagger-ui/index.html
Mermas:https://ms-mermas.onrender.com/swagger-ui/index.html
Episodios:https://ms-episodios.onrender.com/swagger-ui/index.html
Alertas:https://ms-episodios.onrender.com/swagger-ui/index.html


--En nuestro caso lo dejamos habilitado solo para despliegue remoto en render con BD en Aiven que es gratuita

Despliegue Remoto (Producción en Render)
El proyecto está diseñado para desplegarse mediante un Blueprint en Render, utilizando una base de datos externa (Aiven) para garantizar la persistencia.

Configuración de Base de Datos:

En Render, cada microservicio debe tener configuradas las siguientes Variables de Entorno (Environment Variables) que apuntan a tu instancia de Aiven:

SPRING_DATASOURCE_URL: jdbc:mysql://<HOST_AIVEN>:3306/<NOMBRE_BD>

SPRING_DATASOURCE_USERNAME: <usuario>

SPRING_DATASOURCE_PASSWORD: <password>

Despliegue Automático:

Conecta tu repositorio de GitHub a Render.

Crea un nuevo servicio tipo "Blueprint".

Render leerá automáticamente el archivo render.yaml y desplegará todos los microservicios en la nube.

Registro y Descubrimiento:

Una vez que el servicio de Eureka (ms-eureka) esté arriba, los microservicios se registrarán automáticamente utilizando la variable EUREKA_CLIENT_SERVICEURL_DEFAULTZONE configurada en Render.



--Para local no guardamos la configuracion pero es levantar una base de datos con laragon por ejemplo y definirle la conexion,usuario y contraseña ,
basicamente apuntarlo hacia esa BD 