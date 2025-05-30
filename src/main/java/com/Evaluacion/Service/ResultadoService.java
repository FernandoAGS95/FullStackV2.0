package com.Evaluacion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Evaluacion.Client.UsuarioClient;
import com.Evaluacion.Client.DTO.UsuarioDTO;
import com.Evaluacion.Model.Resultado;
import com.Evaluacion.Repository.ResultadoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResultadoService {

    @Autowired
    private ResultadoRepository resultadoRepository;
    @Autowired
    private UsuarioClient usuarioClient;
    //traer todos los resultados de un alumno
    public List<Resultado> obtenerResultadosPorUsuarioId(Long usuarioId) {
        return resultadoRepository.findAll().stream()
            .filter(resultado -> resultado.getUsuarioId().equals(usuarioId))
            .toList();
    }

    //agregar un resultado a un alumno
    public Resultado agregarResultado(Resultado resultado) {
        UsuarioDTO usuario = usuarioClient.obtenerUsuarioPorId(resultado.getUsuarioId());
         if (usuario == null) {
            throw new IllegalArgumentException("El usuario con ID " + resultado.getUsuarioId() + " no existe.");
        }
        System.out.println("El usuario es ; "+usuario);
        return resultadoRepository.save(resultado);
    }

    //actualizar un resultado de un alumno
    public Resultado actualizarResultado(Long id, Resultado resultado) {
        Resultado resultadoExistente = resultadoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Resultado no encontrado"));
        resultadoExistente.setNota(resultado.getNota());
        resultadoExistente.setFechaEntrega(resultado.getFechaEntrega());
        return resultadoRepository.save(resultadoExistente);
    }

}
