package br.com.fecaf.services;

import br.com.fecaf.model.Modelo;
import br.com.fecaf.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> listarModelos() {
        return modeloRepository.findAll();
    }

    public Modelo salvarModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }


    public void deletarModelo(Integer id) {
        modeloRepository.deleteById(id);
    }
}
