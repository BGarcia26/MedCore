package com.MedCore.msmermas.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "merma")
@Data
public class Merma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMerma;
    private Long idInsumo; 
    private Integer cantidad;
    private String motivo; 
    private LocalDateTime fecha;

    @PrePersist
    protected void onCreate() { this.fecha = LocalDateTime.now(); }
}