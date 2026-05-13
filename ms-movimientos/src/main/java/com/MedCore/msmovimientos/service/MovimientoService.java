package com.MedCore.msmovimientos.service;

import com.MedCore.msmovimientos.client.InsumoClient;
import com.MedCore.msmovimientos.model.Movimiento;
import com.MedCore.msmovimientos.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository repository;

    @Autowired
    private InsumoClient insumoClient; 

    public List<Movimiento> listarTodos() {
        return repository.findAll();
    }

    public Movimiento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado con ID: " + id));
    }

    public Movimiento registrar(Movimiento movimiento) {
        try {
            insumoClient.buscarInsumoPorId(movimiento.getIdInsumo());

            return repository.save(movimiento);
        } catch (Exception e) {
            throw new RuntimeException("No se puede registrar el movimiento: El insumo con ID " 
                                        + movimiento.getIdInsumo() + " no existe en el sistema.");
        }
    }

    public Movimiento actualizar(Long id, Movimiento detalles) {
        Movimiento mov = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        
        mov.setCantidad(detalles.getCantidad());
        mov.setMotivo(detalles.getMotivo());
        return repository.save(mov);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}