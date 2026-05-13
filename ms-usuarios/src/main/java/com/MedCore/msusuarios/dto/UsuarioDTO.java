package com.MedCore.msusuarios.dto;

import lombok.Data;
@Data
public class UsuarioDTO {
    private Long idUsuario;
    private String username;
    private String email;
    private String rol;
}
