package com.MedCore.mscategorias;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.MedCore.mscategorias.controller.CategoriaController;
import com.MedCore.mscategorias.model.Categoria;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "eureka.client.enabled=false"
})
class MscategoriasApplicationTests {

    @Autowired
    private CategoriaController controller;

    @Test
    void contextLoads() {
    }

    @Test
    void testInyeccionControlador() {
        assertNotNull(controller, "El CategoriaController debe inyectarse correctamente");
    }

    @Test
    void testInstanciaEntidad() {
        Categoria entidad = new Categoria();
        assertNotNull(entidad, "La entidad Categoria no debe ser nula");
    }
}