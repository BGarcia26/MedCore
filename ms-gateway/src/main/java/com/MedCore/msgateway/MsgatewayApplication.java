package com.MedCore.msgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    public RouterFunction<ServerResponse> routeInsumos(DiscoveryClient discoveryClient) {
        return GatewayRouterFunctions.route("msinsumos")
            .route(path("/api/v1/insumos/**"), HandlerFunctions.http())
            .before(request -> {
                String serviceUrl = discoveryClient.getInstances("msinsumos")
                    .stream()
                    .findFirst()
                    .map(si -> si.getUri().toString())
                    .orElse("http://localhost:8081");
                return BeforeFilterFunctions.uri(serviceUrl).apply(request);
            })
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeUsuarios(DiscoveryClient discoveryClient) {
        return GatewayRouterFunctions.route("msusuarios")
            .route(path("/api/v1/usuarios/**"), HandlerFunctions.http())
            .before(request -> {
                String serviceUrl = discoveryClient.getInstances("msusuarios")
                    .stream()
                    .findFirst()
                    .map(si -> si.getUri().toString())
                    .orElse("http://localhost:8082");
                return BeforeFilterFunctions.uri(serviceUrl).apply(request);
            })
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeCategorias(DiscoveryClient discoveryClient) {
        return GatewayRouterFunctions.route("mscategorias")
            .route(path("/api/v1/categorias/**"), HandlerFunctions.http())
            .before(request -> {
                String serviceUrl = discoveryClient.getInstances("mscategorias")
                    .stream()
                    .findFirst()
                    .map(si -> si.getUri().toString())
                    .orElse("http://localhost:8083");
                return BeforeFilterFunctions.uri(serviceUrl).apply(request);
            })
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeLotes(DiscoveryClient discoveryClient) {
        return GatewayRouterFunctions.route("mslotes")
            .route(path("/api/v1/lotes/**"), HandlerFunctions.http())
            .before(request -> {
                String serviceUrl = discoveryClient.getInstances("mslotes")
                    .stream()
                    .findFirst()
                    .map(si -> si.getUri().toString())
                    .orElse("http://localhost:8084");
                return BeforeFilterFunctions.uri(serviceUrl).apply(request);
            })
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeMovimientos(DiscoveryClient discoveryClient) {
        return GatewayRouterFunctions.route("msmovimientos")
            .route(path("/api/v1/movimientos/**"), HandlerFunctions.http())
            .before(request -> {
                String serviceUrl = discoveryClient.getInstances("msmovimientos")
                    .stream()
                    .findFirst()
                    .map(si -> si.getUri().toString())
                    .orElse("http://localhost:8085");
                return BeforeFilterFunctions.uri(serviceUrl).apply(request);
            })
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeMermas(DiscoveryClient discoveryClient) {
        return GatewayRouterFunctions.route("msmermas")
            .route(path("/api/v1/mermas/**"), HandlerFunctions.http())
            .before(request -> {
                String serviceUrl = discoveryClient.getInstances("msmermas")
                    .stream()
                    .findFirst()
                    .map(si -> si.getUri().toString())
                    .orElse("http://localhost:8086");
                return BeforeFilterFunctions.uri(serviceUrl).apply(request);
            })
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeEpisodios(DiscoveryClient discoveryClient) {
        return GatewayRouterFunctions.route("msepisodios")
            .route(path("/api/v1/episodios/**"), HandlerFunctions.http())
            .before(request -> {
                String serviceUrl = discoveryClient.getInstances("msepisodios")
                    .stream()
                    .findFirst()
                    .map(si -> si.getUri().toString())
                    .orElse("http://localhost:8087");
                return BeforeFilterFunctions.uri(serviceUrl).apply(request);
            })
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeAlertas(DiscoveryClient discoveryClient) {
        return GatewayRouterFunctions.route("msalertas")
            .route(path("/api/v1/alertas/**"), HandlerFunctions.http())
            .before(request -> {
                String serviceUrl = discoveryClient.getInstances("msalertas")
                    .stream()
                    .findFirst()
                    .map(si -> si.getUri().toString())
                    .orElse("http://localhost:8088");
                return BeforeFilterFunctions.uri(serviceUrl).apply(request);
            })
            .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routeReportes(DiscoveryClient discoveryClient) {
        return GatewayRouterFunctions.route("msreportes")
            .route(path("/api/v1/reportes/**"), HandlerFunctions.http())
            .before(request -> {
                String serviceUrl = discoveryClient.getInstances("msreportes")
                    .stream()
                    .findFirst()
                    .map(si -> si.getUri().toString())
                    .orElse("http://localhost:8089");
                return BeforeFilterFunctions.uri(serviceUrl).apply(request);
            })
            .build();
    }
}