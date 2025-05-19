package com.fullstack.usuarios.Controller;

import java.util.List;

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

import com.fullstack.usuarios.Model.TipoUsuario;

import com.fullstack.usuarios.Service.TipoUsuarioService;


@RestController
@RequestMapping("/api/v1/TipoUsuario")
public class TipoUsuarioController {
 @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> Listar() {
        List<TipoUsuario> usuarios = tipoUsuarioService.findAll();
        if(usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    
    @PostMapping
    public ResponseEntity<TipoUsuario> guardar(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario tipoUsuarionuevo = tipoUsuarioService.save(tipoUsuario);
        if (tipoUsuarionuevo == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuarionuevo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> buscar(@PathVariable Long id) {
        try {
            TipoUsuario tipoUsuario = tipoUsuarioService.findById(id);
            return ResponseEntity.ok(tipoUsuario);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> actualizar(@PathVariable Long id, @RequestBody TipoUsuario tipoUsuario) {
        try {
            TipoUsuario usu = tipoUsuarioService.findById(id);
            usu.setId(id);
            usu.setTipoUsuarioDescripcion(tipoUsuario.getTipoUsuarioDescripcion());
            tipoUsuarioService.save(usu);
            return ResponseEntity.ok(tipoUsuario);
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            tipoUsuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch ( Exception e ) {
            return  ResponseEntity.notFound().build();
        }
    }
}
