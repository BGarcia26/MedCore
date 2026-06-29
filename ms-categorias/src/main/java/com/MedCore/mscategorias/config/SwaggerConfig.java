package com.MedCore.mscategorias.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Insumos Médicos")
                        .version("1.0")
                        .description("Documentación de la API para la gestión de categorias de insumos médicos"));
    }
}
