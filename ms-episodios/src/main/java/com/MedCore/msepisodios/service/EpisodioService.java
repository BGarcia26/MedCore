package com.MedCore.msepisodios.service;

import com.MedCore.msepisodios.client.InsumoClient;
import com.MedCore.msepisodios.client.UsuarioClient;
import com.MedCore.msepisodios.model.Episodio;
import com.MedCore.msepisodios.repository.EpisodioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodioService {

    @Autowired
    private EpisodioRepository repository;

    @Autowired
    private InsumoClient insumoClient;

    @Autowired
    private UsuarioClient usuarioClient;

    public List<Episodio> listarTodos() {
        return repository.findAll();
    }

    public Episodio buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Episodio no encontrado con ID: " + id));
    }

    public Episodio registrar(Episodio episodio) {
        try {
            usuarioClient.buscarPorId(episodio.getIdMedico());
            
            insumoClient.buscarInsumoPorId(episodio.getIdInsumo());
            
            return repository.save(episodio);
        } catch (Exception e) {
            throw new RuntimeException("Validación fallida: El ID " + episodio.getIdMedico() + " no existe en Usuarios.");
        }
    }

    public Episodio actualizar(Long id, Episodio detalles) {
        Episodio epi = buscarPorId(id);
        
        epi.setNombrePaciente(detalles.getNombrePaciente());
        epi.setRutPaciente(detalles.getRutPaciente());
        epi.setDescripcion(detalles.getDescripcion());
        epi.setCantidadUtilizada(detalles.getCantidadUtilizada());
        
        return repository.save(epi);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar: El episodio no existe.");
        }
        repository.deleteById(id);
    }
}