package com.MedCore.mslotes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.MedCore.mslotes.controller.LoteController;
import com.MedCore.mslotes.model.Lote;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "eureka.client.enabled=false"
})
class MslotesApplicationTests {

    @Autowired
    private LoteController controller;

    @Test
    void contextLoads() {
    }

    @Test
    void testInyeccionControlador() {
        assertNotNull(controller, "El LoteController debe inyectarse correctamente");
    }

    @Test
    void testInstanciaEntidad() {
        Lote entidad = new Lote();
        assertNotNull(entidad, "La entidad Lote no debe ser nula");
    }
}