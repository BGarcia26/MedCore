package com.MedCore.msinsumos.repository;

import com.MedCore.msinsumos.model.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long> {
    // Heredas automáticamente: save(), findById(), findAll(), deleteById(), etc.
}