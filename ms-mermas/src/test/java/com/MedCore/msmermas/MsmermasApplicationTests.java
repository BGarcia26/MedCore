package com.MedCore.msmermas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.MedCore.msmermas.controller.MermaController;
import com.MedCore.msmermas.model.Merma;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "eureka.client.enabled=false"
})
class MsmermasApplicationTests {

    @Autowired
    private MermaController controller;

    @Test
    void contextLoads() {
    }

    @Test
    void testInyeccionControlador() {
        assertNotNull(controller, "El MermaController debe inyectarse correctamente");
    }

    @Test
    void testInstanciaEntidad() {
        Merma entidad = new Merma();
        assertNotNull(entidad, "La entidad Merma no debe ser nula");
    }
}