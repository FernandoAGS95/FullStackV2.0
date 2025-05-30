package com.materialEducativo.micro.materialEducativo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.materialEducativo.micro.materialEducativo.model.Material;

import com.materialEducativo.micro.materialEducativo.service.MaterialService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/material")
public class materialController {

    @Autowired
    private MaterialService materialservice;

    @GetMapping
    public ResponseEntity<List<Material>> listar() {
        List<Material> material  = materialservice.findAll();
        if (material.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(material);
    }

    @PostMapping
    public ResponseEntity<Material> guardar(@RequestBody Material material) {
        Material materialNuevo = materialservice.save(material);
        if (materialNuevo == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(materialNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> buscar(@PathVariable Long id) {
        try {
            Material material = materialservice.findById(id);
            return ResponseEntity.ok(material);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }
    
        @PutMapping("/{id}")
    public ResponseEntity<Material> actualizar(@PathVariable Long id, @RequestBody Material material) {
        try {
            Material mat = materialservice.findById(id);
            mat.setId(id);
            mat.setTitulo(material.getTitulo());
            mat.setAsignatura(material.getAsignatura());
            mat.setUnidad(material.getUnidad());
            mat.setDescripcion(material.getDescripcion());
            mat.setProfesor(material.getProfesor()); 
            mat.setFecha(material.getFecha());

            materialservice.save(mat);
            return ResponseEntity.ok(material);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            materialservice.delete(id);
            return ResponseEntity.noContent().build();
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }




}
