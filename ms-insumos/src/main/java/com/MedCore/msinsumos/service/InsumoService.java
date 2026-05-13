package com.MedCore.msinsumos.service;

import com.MedCore.msinsumos.dto.InsumoDTO;
import com.MedCore.msinsumos.exception.ResourceNotFoundException;
import com.MedCore.msinsumos.model.Insumo;
import com.MedCore.msinsumos.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository repository;

    public List<InsumoDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public InsumoDTO buscarPorId(Long id) {
        Insumo insumo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Insumo no encontrado con id: " + id));
        return convertirADTO(insumo);
    }

    public Insumo guardar(Insumo insumo) {
        return repository.save(insumo);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar, id no encontrado: " + id);
        }
        repository.deleteById(id);
    }

    public InsumoDTO actualizar(Long id, Insumo detallesInsumo) {
    Insumo insumo = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se puede actualizar, id no encontrado: " + id));
        insumo.setNombre(detallesInsumo.getNombre());
        insumo.setDescripcion(detallesInsumo.getDescripcion());
        insumo.setStockActual(detallesInsumo.getStockActual());
        insumo.setStockMinimo(detallesInsumo.getStockMinimo());
        insumo.setUnidadMedida(detallesInsumo.getUnidadMedida());
        Insumo actualizado = repository.save(insumo);
        return convertirADTO(actualizado);
    }

    private InsumoDTO convertirADTO(Insumo insumo) {
        InsumoDTO dto = new InsumoDTO();
        dto.setIdInsumo(insumo.getIdInsumo());
        dto.setNombre(insumo.getNombre());
        dto.setDescripcion(insumo.getDescripcion());
        dto.setStockActual(insumo.getStockActual());
        dto.setStockMinimo(insumo.getStockMinimo());
        dto.setUnidadMedida(insumo.getUnidadMedida());
        return dto;
    }
}