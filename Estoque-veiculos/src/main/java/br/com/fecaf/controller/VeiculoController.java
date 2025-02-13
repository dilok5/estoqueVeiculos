package br.com.fecaf.controller;

import br.com.fecaf.model.Veiculo;
import br.com.fecaf.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowedHeaders = "*")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;


    @GetMapping("/listarVeiculos")
    public List<Veiculo> listarTodos() {
        return veiculoService.listarTodos();
    }


    @PostMapping("/cadastrarVeiculo")
    public ResponseEntity<Veiculo> salvarVeiculo(@RequestBody Veiculo veiculo) {
        Veiculo newVeiculo = veiculoService.salvarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVeiculo);
    }


    @PutMapping("/atualizarVeiculo/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Integer id, @RequestBody Veiculo veiculo) {
        Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(id, veiculo);

        if(veiculoAtualizado != null){
            return ResponseEntity.ok(veiculoAtualizado);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deletarVeiculo/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Integer id) {
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}