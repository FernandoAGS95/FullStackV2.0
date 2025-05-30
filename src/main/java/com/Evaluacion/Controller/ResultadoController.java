package com.Evaluacion.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Evaluacion.Model.Resultado;
import com.Evaluacion.Service.ResultadoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/v1/resultado")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    //get
    @GetMapping
    public List<Resultado> getResultadoById(@RequestParam Long id) {
        return resultadoService.obtenerResultadosPorUsuarioId(id);
    }
    
    @PostMapping
    public ResponseEntity<Resultado> postMethodName(@RequestBody Resultado entity) {
        System.out.println(entity);
        Resultado resultado = resultadoService.agregarResultado(entity);
        return ResponseEntity.ok(resultado);
    }
    

}
