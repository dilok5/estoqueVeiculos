package br.com.fecaf.services;

import br.com.fecaf.model.Veiculo;
import br.com.fecaf.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    //listar veiculos
    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    //salvar veiculos
    public Veiculo salvarVeiculo(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }


    //deletar veiculo
    public void deletarVeiculo(int id){
        veiculoRepository.deleteById(id);
    }

    //Atualizar veiculo
    public Veiculo atualizarVeiculo(Integer id, Veiculo veiculo) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(id);

        if(veiculoExistente.isPresent()){
            Veiculo veiculoAtualizado = veiculoExistente.get();
            veiculoAtualizado.setModelo(veiculo.getModelo());
            veiculoAtualizado.setAnoFabricacao(veiculo.getAnoFabricacao());
            veiculoAtualizado.setCor(veiculo.getCor());
            veiculoAtualizado.setPreco(veiculo.getPreco());
            veiculoAtualizado.setQuilometragem(veiculo.getQuilometragem());
            veiculoAtualizado.setStatusDisponibilidade(veiculo.getStatusDisponibilidade());
            return veiculoRepository.save(veiculoAtualizado);
        }else {
            return null;
        }
    }

}