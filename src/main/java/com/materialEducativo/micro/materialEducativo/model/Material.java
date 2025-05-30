package com.materialEducativo.micro.materialEducativo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "material")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Material {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable= false)
    private String titulo;

    @Column(nullable= false)
    private String asignatura;

    @Column(nullable= false)
    private String unidad;

    @Column(nullable= false)
    private String descripcion;

    @Column(nullable= false)
    private String profesor;

    @Column(nullable= false)
    private String fecha;
}
