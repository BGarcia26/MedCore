package com.MedCore.msmermas.repository;

import com.MedCore.msmermas.model.Merma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MermaRepository extends JpaRepository<Merma, Long> {
}

