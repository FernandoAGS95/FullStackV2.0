package com.fullstack.usuarios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.usuarios.Model.HistorialUsuario;

public interface HistorialUsuarioRepository extends JpaRepository<HistorialUsuario, Long> {
}
