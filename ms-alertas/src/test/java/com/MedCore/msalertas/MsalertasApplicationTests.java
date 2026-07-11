package com.MedCore.msalertas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.MedCore.msalertas.controller.AlertaController;
import com.MedCore.msalertas.model.Alerta;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "eureka.client.enabled=false"
})
class MsalertasApplicationTests {

    @Autowired
    private AlertaController controller;

    @Test
    void contextLoads() {
    }

    @Test
    void testInyeccionControlador() {
        assertNotNull(controller, "El AlertaController debe inyectarse correctamente");
    }

    @Test
    void testInstanciaEntidad() {
        Alerta entidad = new Alerta();
        assertNotNull(entidad, "La entidad Alerta no debe ser nula");
    }
}