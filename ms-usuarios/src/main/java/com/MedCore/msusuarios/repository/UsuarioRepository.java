package com.MedCore.msusuarios.repository;

import com.MedCore.msusuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Este método es clave para el Login que haremos después
    Optional<Usuario> findByUsername(String username);
}
