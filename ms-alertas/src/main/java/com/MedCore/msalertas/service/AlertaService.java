package com.MedCore.msalertas.service;

import com.MedCore.msalertas.client.InsumoClient;
import com.MedCore.msalertas.model.Alerta;
import com.MedCore.msalertas.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository repository;

    @Autowired
    private InsumoClient insumoClient;

    public List<Alerta> listarTodas() {
        return repository.findAll();
    }

    public Alerta buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta no encontrada con ID: " + id));
    }

    public Alerta registrar(Alerta alerta) {
        try {
            // Validación: Ir a buscar si el insumo existe en el MS de Insumos
            insumoClient.buscarInsumoPorId(alerta.getIdInsumo());
            return repository.save(alerta);
        } catch (Exception e) {
            throw new RuntimeException("No se puede crear alerta: El Insumo " + alerta.getIdInsumo() + " no existe.");
        }
    }

    public Alerta actualizar(Long id, Alerta detalles) {
        Alerta alerta = buscarPorId(id);
        alerta.setMensaje(detalles.getMensaje());
        alerta.setNivelPrioridad(detalles.getNivelPrioridad());
        return repository.save(alerta);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}