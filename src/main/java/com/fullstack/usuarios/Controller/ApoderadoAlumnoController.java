package com.fullstack.usuarios.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.usuarios.Model.ApoderadoAlumno;

import com.fullstack.usuarios.Service.ApoderadoAlumnoService;


@RestController
@RequestMapping("/api/v1/apoderadoAlumno")
public class ApoderadoAlumnoController {
@Autowired
    private ApoderadoAlumnoService apoderadoAlumnoService;

    @GetMapping
    public ResponseEntity<List<ApoderadoAlumno>> Listar() {
        List<ApoderadoAlumno> apoAlum = apoderadoAlumnoService.findAll();
        if(apoAlum.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(apoAlum);
    }
    
    @PostMapping
    public ResponseEntity<ApoderadoAlumno> guardar(@RequestBody ApoderadoAlumno apoderadoAlumno) {
        ApoderadoAlumno nuevoApoAlum = apoderadoAlumnoService.save(apoderadoAlumno);
        if (nuevoApoAlum == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoApoAlum);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApoderadoAlumno> buscar(@PathVariable Long id) {
        try {
            ApoderadoAlumno apoderadoAlumno = apoderadoAlumnoService.findById(id);
            return ResponseEntity.ok(apoderadoAlumno);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }




    //En caso de algun ingreso erroneo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            apoderadoAlumnoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }
}
