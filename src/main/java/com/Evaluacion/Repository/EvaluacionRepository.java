package com.Evaluacion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Evaluacion.Model.Evaluacion;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar evaluaciones por curso o asignatura

}
