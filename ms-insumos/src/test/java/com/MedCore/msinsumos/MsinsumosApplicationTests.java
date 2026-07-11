package com.MedCore.msinsumos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.MedCore.msinsumos.controller.InsumoController;
import com.MedCore.msinsumos.model.Insumo;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "eureka.client.enabled=false"
})
class MsinsumosApplicationTests {

    @Autowired
    private InsumoController controller;

    @Test
    void contextLoads() {
    }

    @Test
    void testInyeccionControlador() {
        assertNotNull(controller, "El InsumoController debe inyectarse correctamente");
    }

    @Test
    void testInstanciaEntidad() {
        Insumo entidad = new Insumo();
        assertNotNull(entidad, "La entidad Insumo no debe ser nula");
    }
}