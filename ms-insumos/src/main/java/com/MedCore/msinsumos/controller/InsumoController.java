package com.MedCore.msinsumos.controller;

import com.MedCore.msinsumos.dto.InsumoDTO;
import com.MedCore.msinsumos.model.Insumo;
import com.MedCore.msinsumos.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/insumos")
public class InsumoController {

    @Autowired
    private InsumoService insumoService;

    @GetMapping
    public List<InsumoDTO> obtenerTodos() {
        return insumoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsumoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(insumoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<InsumoDTO> crearInsumo(@RequestBody Insumo insumo) {
        Insumo guardado = insumoService.guardar(insumo);
        return ResponseEntity.ok(insumoService.buscarPorId(guardado.getIdInsumo()));
    }

    @PostMapping("/{id}/actualizar-stock")
    public ResponseEntity<Void> actualizarStock(
        @PathVariable("id") Long id,             
        @RequestBody Integer cantidad 
    ) {
        insumoService.actualizarStock(id, cantidad);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<InsumoDTO> actualizarInsumo(@PathVariable Long id, @RequestBody Insumo detallesInsumo) {
        return ResponseEntity.ok(insumoService.actualizar(id, detallesInsumo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInsumo(@PathVariable Long id) {
        insumoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}