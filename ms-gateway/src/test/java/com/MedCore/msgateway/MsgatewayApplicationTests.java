package com.MedCore.msgateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Apagamos Eureka para que el test local no falle buscando el servidor
@SpringBootTest(properties = {
    "eureka.client.enabled=false"
})
class MsgatewayApplicationTests {

    @Test
    void contextLoads() {
    }
}