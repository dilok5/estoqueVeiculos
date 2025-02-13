package br.com.fecaf.services;

import br.com.fecaf.model.Marca;
import br.com.fecaf.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;


    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    public Marca salvarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }


    public void deletarMarca(int id) {
        marcaRepository.deleteById(id);
    }
}
