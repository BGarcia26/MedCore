package com.MedCore.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

@SpringBootApplication
public class MsgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsgatewayApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> routeInsumos() {
        return GatewayRouterFunctions.route("ms-insumos")
            .route(path("/api/v1/insumos/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("http://localhost:8081"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeUsuarios() {
        return GatewayRouterFunctions.route("ms-usuarios")
            .route(path("/api/v1/usuarios/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("http://localhost:8082"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeCategorias() {
        return GatewayRouterFunctions.route("ms-categorias")
            .route(path("/api/v1/categorias/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("http://localhost:8083"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeLotes() {
        return GatewayRouterFunctions.route("ms-lotes")
            .route(path("/api/v1/lotes/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("http://localhost:8084"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeMovimientos() {
        return GatewayRouterFunctions.route("ms-movimientos")
            .route(path("/api/v1/movimientos/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("http://localhost:8085"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeMermas() {
        return GatewayRouterFunctions.route("ms-mermas")
            .route(path("/api/v1/mermas/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("http://localhost:8086"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeEpisodios() {
        return GatewayRouterFunctions.route("ms-episodios")
            .route(path("/api/v1/episodios/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("http://localhost:8087"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeAlertas() {
        return GatewayRouterFunctions.route("ms-alertas")
            .route(path("/api/v1/alertas/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("http://localhost:8088"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeReportes() {
        return GatewayRouterFunctions.route("ms-reportes")
            .route(path("/api/v1/reportes/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("http://localhost:8089"))
            .build();
    }
}