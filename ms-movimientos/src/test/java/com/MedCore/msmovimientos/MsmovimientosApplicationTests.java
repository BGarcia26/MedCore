package com.MedCore.msmovimientos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.MedCore.msmovimientos.controller.MovimientoController;
import com.MedCore.msmovimientos.model.Movimiento;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "eureka.client.enabled=false"
})
class MsmovimientosApplicationTests {

    @Autowired
    private MovimientoController controller;

    @Test
    void contextLoads() {
    }

    @Test
    void testInyeccionControlador() {
        assertNotNull(controller, "El MovimientoController debe inyectarse correctamente");
    }

    @Test
    void testInstanciaEntidad() {
        Movimiento entidad = new Movimiento();
        assertNotNull(entidad, "La entidad Movimiento no debe ser nula");
    }
}