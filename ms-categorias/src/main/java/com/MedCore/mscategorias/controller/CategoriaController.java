package com.MedCore.mscategorias.controller;

import com.MedCore.mscategorias.dto.CategoriaDTO;
import com.MedCore.mscategorias.model.Categoria;
import com.MedCore.mscategorias.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<CategoriaDTO> listar() { return service.listarTodas(); }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> crear(@RequestBody Categoria cat) {
        return ResponseEntity.ok(service.guardar(cat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> editar(@PathVariable Long id, @RequestBody Categoria cat) {
        return ResponseEntity.ok(service.actualizar(id, cat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}