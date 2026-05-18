package com.MedCore.msmovimientos.dto;

import lombok.Data;

@Data
public class MovimientoDTO {
    private Long idInsumo;
    private Integer cantidad;
    private String tipo;
    private String motivo;
}