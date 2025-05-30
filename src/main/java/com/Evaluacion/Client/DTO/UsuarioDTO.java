package com.Evaluacion.Client.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private TipoUsuarioDTO tipoUsuario; // Cambiado de String a TipoUsuarioDTO
    private String run;
    private String nombres;
    private String password;
    private String username;
    private String apellidos;
    private String fechaNacimiento;
    private String correo;

    @Data
    public static class TipoUsuarioDTO {
        private Long id;
        private String tipoUsuarioDescripcion;
    }
}