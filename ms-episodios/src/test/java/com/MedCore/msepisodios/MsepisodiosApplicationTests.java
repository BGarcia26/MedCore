package com.MedCore.msepisodios;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.MedCore.msepisodios.controller.EpisodioController;
import com.MedCore.msepisodios.model.Episodio;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "eureka.client.enabled=false"
})
class MsepisodiosApplicationTests {

    @Autowired
    private EpisodioController controller;

    @Test
    void contextLoads() {
    }

    @Test
    void testInyeccionControlador() {
        assertNotNull(controller, "El EpisodioController debe inyectarse correctamente");
    }

    @Test
    void testInstanciaEntidad() {
        Episodio entidad = new Episodio();
        assertNotNull(entidad, "La entidad Episodio no debe ser nula");
    }
}