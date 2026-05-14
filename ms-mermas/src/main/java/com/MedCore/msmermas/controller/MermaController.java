package com.MedCore.msmermas.controller;

import com.MedCore.msmermas.model.Merma;
import com.MedCore.msmermas.service.MermaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mermas")
public class MermaController {

    @Autowired
    private MermaService service;

    @GetMapping
    public List<Merma> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Merma> obtenerPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Merma merma) {
        try {
            return ResponseEntity.ok(service.registrar(merma));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Merma> editar(@PathVariable Long id, @RequestBody Merma merma) {
        try {
            return ResponseEntity.ok(service.actualizar(id, merma));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}