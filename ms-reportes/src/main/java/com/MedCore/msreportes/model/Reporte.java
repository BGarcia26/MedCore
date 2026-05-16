package com.MedCore.msreportes.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {
    @JsonProperty("idInsumo")
    private Long id;
    private String nombre;
    private Integer stockActual;
    private String categoria;
    private String estado; 

    public Long getId() {
        return this.id;
    }
}