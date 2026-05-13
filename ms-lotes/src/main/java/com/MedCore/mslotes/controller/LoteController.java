package com.MedCore.mslotes.controller;

import com.MedCore.mslotes.model.Lote;
import com.MedCore.mslotes.service.LoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lotes")
public class LoteController {
    @Autowired
    private LoteService service;

    @GetMapping
    public List<Lote> listar() { return service.listarTodos(); }

    @GetMapping("/{id}")
    public Lote obtener(@PathVariable Long id) { return service.buscarPorId(id); }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Lote lote) {
        try {
            return ResponseEntity.ok(service.guardar(lote));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Lote> editar(@PathVariable Long id, @RequestBody Lote lote) {
        return ResponseEntity.ok(service.actualizar(id, lote));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
