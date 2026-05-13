package com.MedCore.mscategorias.service;

import com.MedCore.mscategorias.dto.CategoriaDTO;
import com.MedCore.mscategorias.model.Categoria;
import com.MedCore.mscategorias.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<CategoriaDTO> listarTodas() {
        return repository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public CategoriaDTO buscarPorId(Long id) {
        Categoria cat = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + id));
        return convertirADTO(cat);
    }

    public CategoriaDTO guardar(Categoria categoria) {
        return convertirADTO(repository.save(categoria));
    }

    public CategoriaDTO actualizar(Long id, Categoria detalles) {
        Categoria cat = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        cat.setNombre(detalles.getNombre());
        cat.setDescripcion(detalles.getDescripcion());
        return convertirADTO(repository.save(cat));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    private CategoriaDTO convertirADTO(Categoria cat) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setIdCategoria(cat.getIdCategoria());
        dto.setNombre(cat.getNombre());
        dto.setDescripcion(cat.getDescripcion());
        return dto;
    }
}