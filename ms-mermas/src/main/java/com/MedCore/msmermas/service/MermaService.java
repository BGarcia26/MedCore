package com.MedCore.msmermas.service;

import com.MedCore.msmermas.client.InsumoClient;
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

    public Merma registrar(Merma merma) {
        try {
            // Validación Feign: ir a buscar el insumo al puerto 8081
            insumoClient.buscarInsumoPorId(merma.getIdInsumo());
            return repository.save(merma);
        } catch (Exception e) {
            throw new RuntimeException("Error: El Insumo " + merma.getIdInsumo() + " no existe.");
        }
    }

    public Merma actualizar(Long id, Merma detalles) {
        Merma merma = buscarPorId(id);
        
        merma.setCantidad(detalles.getCantidad());
        merma.setMotivo(detalles.getMotivo());
        // El idInsumo generalmente no se cambia en una merma ya registrada
        
        return repository.save(merma);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}