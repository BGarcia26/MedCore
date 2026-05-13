package com.MedCore.mslotes.repository;

import com.MedCore.mslotes.model.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {
}