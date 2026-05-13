package com.MedCore.msusuarios.service;

import com.MedCore.msusuarios.dto.UsuarioDTO;
import com.MedCore.msusuarios.model.Usuario;
import com.MedCore.msusuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO guardar(Usuario usuario) {
        Usuario guardado = repository.save(usuario);
        return convertirADTO(guardado);
    }

    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return convertirADTO(usuario);
    }

    public UsuarioDTO actualizar(Long id, Usuario detalles) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se puede actualizar, usuario no encontrado"));
        
        usuario.setUsername(detalles.getUsername());
        usuario.setEmail(detalles.getEmail());
        usuario.setRol(detalles.getRol());
        // Solo actualizamos la password si viene en el cuerpo
        if(detalles.getPassword() != null) {
            usuario.setPassword(detalles.getPassword());
        }

        Usuario actualizado = repository.save(usuario);
        return convertirADTO(actualizado);
    }

    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No se puede eliminar, usuario no existe");
        }
        repository.deleteById(id);
    }

    private UsuarioDTO convertirADTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setUsername(usuario.getUsername());
        dto.setEmail(usuario.getEmail());
        dto.setRol(usuario.getRol());
        return dto;
    }
}