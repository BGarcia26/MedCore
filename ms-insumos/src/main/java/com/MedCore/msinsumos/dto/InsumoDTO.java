package com.MedCore.msinsumos.dto;

import lombok.Data;

@Data
public class InsumoDTO {
    private Long idInsumo;
    private String nombre;
    private String descripcion;
    private Integer stockActual;
    private Integer stockMinimo;
    private String unidadMedida;
}