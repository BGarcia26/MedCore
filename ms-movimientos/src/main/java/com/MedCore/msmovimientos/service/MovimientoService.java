package com.MedCore.msmovimientos.service;

import com.MedCore.msmovimientos.client.InsumoClient;
import com.MedCore.msmovimientos.dto.MovimientoDTO;
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

    public Movimiento registrar(MovimientoDTO dto) {
        try {
            insumoClient.buscarInsumoPorId(dto.getIdInsumo());
            

            String tipo = dto.getTipo().toUpperCase();
            Integer cantidadAjustada = tipo.equals("SALIDA") 
                                    ? -dto.getCantidad() 
                                    : dto.getCantidad();
            
            insumoClient.actualizarStock(dto.getIdInsumo(), cantidadAjustada);

            Movimiento movimiento = new Movimiento();
            movimiento.setIdInsumo(dto.getIdInsumo());
            movimiento.setCantidad(dto.getCantidad());
            movimiento.setTipo(tipo);
            movimiento.setMotivo(dto.getMotivo());

            return repository.save(movimiento);
            
        } catch (Exception e) {
            throw new RuntimeException("Error en el proceso: " + e.getMessage());
        }
    }

    public Movimiento actualizar(Long id, MovimientoDTO detalles) {
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