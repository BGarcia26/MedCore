package com.MedCore.msusuarios;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.MedCore.msusuarios.controller.UsuarioController;
import com.MedCore.msusuarios.model.Usuario;

@SpringBootTest(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb",
    "spring.datasource.driverClassName=org.h2.Driver",
    "spring.datasource.username=sa",
    "spring.datasource.password=",
    "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
    "eureka.client.enabled=false"
})
class MsusuariosApplicationTests {

    @Autowired
    private UsuarioController controller;

    @Test
    void contextLoads() {
    }

    @Test
    void testInyeccionControlador() {
        assertNotNull(controller, "El UsuarioController debe inyectarse correctamente");
    }

    @Test
    void testInstanciaEntidad() {
        Usuario entidad = new Usuario();
        assertNotNull(entidad, "La entidad Usuario no debe ser nula");
    }
}