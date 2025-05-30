package com.Evaluacion.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Evaluacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private LocalDate fecha;

    //@ManyToOne
   // @JoinColumn(name = "curso_id")
   // private Curso curso;

   // @ManyToOne
    //@JoinColumn(name = "asignatura_id")
    //private Asignatura asignatura;

    @Column(nullable = false)
    private Long idCreador; // ID del usuario que creó la evaluación
}
