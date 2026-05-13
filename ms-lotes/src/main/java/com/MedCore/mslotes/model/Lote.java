package com.MedCore.mslotes.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "lote")
@Data
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLote;

    private Long idInsumo; 

    @Column(nullable = false)
    private String codigoLote; 
    
    private LocalDate fechaVencimiento;
    private Integer cantidadInicial;
}