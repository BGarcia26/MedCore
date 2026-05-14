package com.MedCore.msalertas.controller;

import com.MedCore.msalertas.model.Alerta;
import com.MedCore.msalertas.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/alertas")
public class AlertaController {

    @Autowired
    private AlertaService service;

    @GetMapping
    public List<Alerta> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alerta> obtenerPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alerta alerta) {
        try {
            return ResponseEntity.ok(service.registrar(alerta));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alerta> editar(@PathVariable Long id, @RequestBody Alerta alerta) {
        return ResponseEntity.ok(service.actualizar(id, alerta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
