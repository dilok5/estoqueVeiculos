package br.com.fecaf.controller;

import br.com.fecaf.model.Modelo;
import br.com.fecaf.services.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/modelos")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;


    @GetMapping("/listarModelos")
    public List<Modelo> listarModelos() {
        return modeloService.listarModelos();
    }


    @PostMapping("/cadastrarModelo")
    public ResponseEntity<Modelo> salvarModelo(@RequestBody Modelo modelo) {
        Modelo newModelo = modeloService.salvarModelo(modelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newModelo);
    }


    @DeleteMapping("/deletarModelo/{id}")
    public ResponseEntity<Void> deletarModelo(@PathVariable int id) {
        modeloService.deletarModelo(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
