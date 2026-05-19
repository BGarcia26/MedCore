package com.MedCore.msmermas.service;

import com.MedCore.msmermas.client.InsumoClient;
import com.MedCore.msmermas.dto.MermaDTO;
import com.MedCore.msmermas.model.Merma;
import com.MedCore.msmermas.repository.MermaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MermaService {

    @Autowired
    private MermaRepository repository;

    @Autowired
    private InsumoClient insumoClient;

    public List<Merma> listarTodas() {
        return repository.findAll();
    }

    public Merma buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merma no encontrada con ID: " + id));
    }

    public Merma registrar(MermaDTO dto) {
        if (dto.getIdInsumo() == null) throw new RuntimeException("El ID del insumo es obligatorio");
        if (dto.getCantidad() == null || dto.getCantidad() <= 0) {
            throw new RuntimeException("La cantidad de merma debe ser un número positivo");
        }
        if (dto.getMotivo() == null || dto.getMotivo().trim().isEmpty()) {
            throw new RuntimeException("El motivo de la merma no puede estar vacío");
        }

        try {
            // 1. Verificamos que el insumo exista
            insumoClient.buscarInsumoPorId(dto.getIdInsumo());

            // 2. Descontamos el stock (Merma siempre es RESTA, por eso el negativo)
            int cantidadADescontar = -Math.abs(dto.getCantidad());
            insumoClient.actualizarStock(dto.getIdInsumo(), cantidadADescontar);

            Merma merma = new Merma();
            merma.setIdInsumo(dto.getIdInsumo());
            merma.setCantidad(dto.getCantidad());
            merma.setMotivo(dto.getMotivo());

            return repository.save(merma);

        } catch (Exception e) {
            // Esto captura si el microservicio de insumos devuelve error (ej: no hay stock)
            throw new RuntimeException("Error en la operación de merma: " + e.getMessage());
        }
    }

    public Merma actualizar(Long id, Merma detalles) {
        Merma merma = buscarPorId(id);
        
        merma.setCantidad(detalles.getCantidad());
        merma.setMotivo(detalles.getMotivo());
        return repository.save(merma);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}