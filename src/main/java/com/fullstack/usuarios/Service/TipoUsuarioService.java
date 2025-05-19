package com.fullstack.usuarios.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.usuarios.Model.TipoUsuario;

import com.fullstack.usuarios.Repository.TipoUsuarioRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoUsuarioService {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public List<TipoUsuario> findAll() {
        return tipoUsuarioRepository.findAll();
    }

    public TipoUsuario findById(Long id) {
        return tipoUsuarioRepository.findById(id).get();
    }

    public TipoUsuario save(TipoUsuario usuario) {
        return tipoUsuarioRepository.save(usuario);
    }
    public void delete(Long id) {
        tipoUsuarioRepository.deleteById(id);
    }
}
