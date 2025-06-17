package com.fullstack.usuarios.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TipoUsuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoUsuarioDescripcion;

    public String getTipoUsuarioDescripcion() {
        return tipoUsuarioDescripcion;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipoUsuarioDescripcion(String tipoUsuarioDescripcion) {
        this.tipoUsuarioDescripcion = tipoUsuarioDescripcion;
    }
    
}