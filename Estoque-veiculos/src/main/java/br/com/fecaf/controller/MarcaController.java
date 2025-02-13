package br.com.fecaf.controller;

import br.com.fecaf.model.Marca;
import br.com.fecaf.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/marcas")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;


    @GetMapping("/listarMarcas")
    public List<Marca> listarMarcas() {
        return marcaService.listarMarcas();
    }


    @PostMapping("/cadastrarMarca")
    public ResponseEntity<Marca> cadastrarMarca(@RequestBody Marca marca) {
        Marca newMarca = marcaService.salvarMarca(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMarca);
    }


    @DeleteMapping("/deletarMarca/{id}")
    public ResponseEntity<Void> deletarMarca(@PathVariable int id) {
        marcaService.deletarMarca(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
