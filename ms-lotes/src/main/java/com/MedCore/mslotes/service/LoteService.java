package com.MedCore.mslotes.service;

import com.MedCore.mslotes.client.InsumoClient;
import com.MedCore.mslotes.model.Lote;
import com.MedCore.mslotes.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteService {
    @Autowired
    private LoteRepository repository;

    @Autowired
    private InsumoClient insumoClient;

    public List<Lote> listarTodos() { return repository.findAll(); }

    public Lote buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Lote no encontrado"));
    }

    public Lote guardar(Lote lote) {
        try {
            insumoClient.buscarInsumoPorId(lote.getIdInsumo());
            return repository.save(lote);
        } catch (Exception e) {
            throw new RuntimeException("Error: El insumo " + lote.getIdInsumo() + " no existe.");
        }
    }

    public Lote actualizar(Long id, Lote detalles) {
        Lote lote = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lote no encontrado con ID: " + id));
        lote.setCodigoLote(detalles.getCodigoLote());
        lote.setFechaVencimiento(detalles.getFechaVencimiento());
        lote.setCantidadInicial(detalles.getCantidadInicial());
        
        return repository.save(lote);
    }

    public void eliminar(Long id) { repository.deleteById(id); }
}
