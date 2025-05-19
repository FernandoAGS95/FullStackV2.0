package com.fullstack.usuarios.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.usuarios.Model.HistorialUsuario;

import com.fullstack.usuarios.Service.HistorialUsuarioService;

@RestController
@RequestMapping("/api/v1/historialUsuario")
public class historialUsuarioController {
    @Autowired
    private HistorialUsuarioService historialUsuarioService;

    @GetMapping
    public ResponseEntity<List<HistorialUsuario>> Listar() {
        List<HistorialUsuario> historialUsuario = historialUsuarioService.findAll();
        if(historialUsuario.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(historialUsuario);
    }
    
    @PostMapping
    public ResponseEntity<HistorialUsuario> guardar(@RequestBody HistorialUsuario historialUsuario) {
        HistorialUsuario historialUsuarionew = historialUsuarioService.save(historialUsuario);
        if (historialUsuarionew == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(historialUsuarionew);
    }
    @GetMapping("/{id}")
    public ResponseEntity<HistorialUsuario> buscar(@PathVariable Long id) {
        try {
            HistorialUsuario historialUsuarioBuscado = historialUsuarioService.findById(id);
            return ResponseEntity.ok(historialUsuarioBuscado);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }
    // NO debieramos actualizar el historial de un usuario o borrarlo
    
}
