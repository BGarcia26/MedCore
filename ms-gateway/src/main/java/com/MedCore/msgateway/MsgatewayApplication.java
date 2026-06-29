package com.MedCore.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.path;

@SpringBootApplication
@EnableEurekaServer
public class MsgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsgatewayApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> routeInsumos() {
        return GatewayRouterFunctions.route("msinsumos")
            .route(path("/api/v1/insumos/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("lb://msinsumos"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeUsuarios() {
        return GatewayRouterFunctions.route("msusuarios")
            .route(path("/api/v1/usuarios/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("lb://msusuarios"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeCategorias() {
        return GatewayRouterFunctions.route("mscategorias")
            .route(path("/api/v1/categorias/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("lb://mscategorias"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeLotes() {
        return GatewayRouterFunctions.route("mslotes")
            .route(path("/api/v1/lotes/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("lb://mslotes"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeMovimientos() {
        return GatewayRouterFunctions.route("msmovimientos")
            .route(path("/api/v1/movimientos/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("lb://msmovimientos"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeMermas() {
        return GatewayRouterFunctions.route("msmermas")
            .route(path("/api/v1/mermas/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("lb://msmermas"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeEpisodios() {
        return GatewayRouterFunctions.route("msepisodios")
            .route(path("/api/v1/episodios/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("lb://msepisodios"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeAlertas() {
        return GatewayRouterFunctions.route("msalertas")
            .route(path("/api/v1/alertas/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("lb://msalertas"))
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeReportes() {
        return GatewayRouterFunctions.route("msreportes")
            .route(path("/api/v1/reportes/**"), HandlerFunctions.http())
            .before(BeforeFilterFunctions.uri("lb://msreportes"))
            .build();
    }
}