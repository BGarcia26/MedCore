package com.MedCore.msepisodios.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "episodio")
@Data
public class Episodio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEpisodio;

    private String nombrePaciente;
    private String rutPaciente;
    
    @Column(name = "id_usuario")
    private Long idMedico;
    private Long idInsumo; 

    private Integer cantidadUtilizada;
    private String descripcion;
    private LocalDateTime fechaIngreso;

    @PrePersist
    protected void onCreate() { this.fechaIngreso = LocalDateTime.now(); }
}