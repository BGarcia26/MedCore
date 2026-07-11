package com.MedCore.msreportes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.MedCore.msreportes.controller.ReporteController;
import com.MedCore.msreportes.model.Reporte;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "eureka.client.enabled=false"
})
class MsreportesApplicationTests {

    @Autowired
    private ReporteController controller;

    @Test
    void contextLoads() {
    }

    @Test
    void testInyeccionControlador() {
        assertNotNull(controller, "El ReporteController debe inyectarse correctamente");
    }

    @Test
    void testInstanciaEntidad() {
        Reporte entidad = new Reporte();
        assertNotNull(entidad, "La entidad Reporte no debe ser nula");
    }
}