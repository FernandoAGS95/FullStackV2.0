package com.fullstack.usuarios.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.usuarios.Model.ApoderadoAlumno;

import com.fullstack.usuarios.Repository.ApoderadoAlumnoRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class ApoderadoAlumnoService {
 @Autowired
    private ApoderadoAlumnoRepository apoderadoAlumnoRepository;

    public List<ApoderadoAlumno> findAll() {
        return apoderadoAlumnoRepository.findAll();
    }

    public ApoderadoAlumno findById(Long id) {
        return apoderadoAlumnoRepository.findById(id).get();
    }

    public ApoderadoAlumno save(ApoderadoAlumno usuario) {
        return apoderadoAlumnoRepository.save(usuario);
    }
    public void delete(Long id) {
        apoderadoAlumnoRepository.deleteById(id);
    }
}
