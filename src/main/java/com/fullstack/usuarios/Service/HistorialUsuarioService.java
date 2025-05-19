package com.fullstack.usuarios.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.usuarios.Model.HistorialUsuario;
import com.fullstack.usuarios.Repository.HistorialUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HistorialUsuarioService {
    @Autowired
    private HistorialUsuarioRepository historialUsuarioRepository;

    public List<HistorialUsuario> findAll() {
        return historialUsuarioRepository.findAll();
    }

    public HistorialUsuario findById(Long id) {
        return historialUsuarioRepository.findById(id).get();
    }

    public HistorialUsuario save(HistorialUsuario usuario) {
        return historialUsuarioRepository.save(usuario);
    }
    public void delete(Long id) {
        historialUsuarioRepository.deleteById(id);
    }
}
