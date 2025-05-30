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
@Table(name = "Resultado")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double nota;
    @Column(nullable = false)
    private LocalDate fechaEntrega;

    @Column(nullable = false)
    private Long usuarioId;  // ID del alumno en el microservicio de usuarios

   // @ManyToOne
    //@JoinColumn(name = "evaluacion_id", nullable = false)
    //private Evaluacion evaluacion;
}
