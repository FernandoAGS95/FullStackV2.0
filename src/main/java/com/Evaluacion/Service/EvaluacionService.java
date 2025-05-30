package com.Evaluacion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Evaluacion.Model.Evaluacion;
import com.Evaluacion.Repository.EvaluacionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EvaluacionService {
    
    @Autowired
    private EvaluacionRepository evaluacionRepository;

    //Agregar una evaluacion
    public Evaluacion agregarEvaluacion(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }
    //Actualizar una evaluacion
    public Evaluacion actualizarEvaluacion(Long id, Evaluacion evaluacion) {
        Evaluacion evaluacionExistente = evaluacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Evaluación no encontrada"));
        evaluacionExistente.setNombre(evaluacion.getNombre());
        evaluacionExistente.setDescripcion(evaluacion.getDescripcion());
        return evaluacionRepository.save(evaluacionExistente);
    }
}
