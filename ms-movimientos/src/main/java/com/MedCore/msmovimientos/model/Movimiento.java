package com.MedCore.msmovimientos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento")
@Data
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;
    private Long idInsumo; 
    private Integer cantidad;
    private String tipo; // ENTRADA o SALIDA
    private String motivo;
    private LocalDateTime fecha;

    @PrePersist
    protected void onCreate() { this.fecha = LocalDateTime.now(); }
}