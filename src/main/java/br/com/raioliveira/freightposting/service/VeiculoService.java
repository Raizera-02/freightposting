package br.com.raioliveira.freightposting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.raioliveira.freightposting.model.Veiculo;
import br.com.raioliveira.freightposting.repository.FreteRepository;
import br.com.raioliveira.freightposting.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    private final FreteRepository freteRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository, FreteRepository freteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.freteRepository = freteRepository;
    }

    public Veiculo salvarVeiculo(Veiculo veiculo) {
        validarVeiculoExistente(veiculo);        
        return veiculoRepository.save(veiculo);
    }

    private void validarVeiculoExistente(Veiculo veiculo) {
        // Verifica se já existe um veículo com a mesma placa
        if (veiculoRepository.existsByPlaca(veiculo.getPlaca())) {
            throw new IllegalArgumentException("Veículo com a placa " + veiculo.getPlaca() + " já cadastrado.");
        }
    }

    public List<Veiculo> listarTodosVeiculos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarVeiculoPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo atualizarVeiculo(Long id, Veiculo novoVeiculo) {
        Optional<Veiculo> optionalVeiculo = veiculoRepository.findById(id);

        validarVeiculoExistente(novoVeiculo);

        if (optionalVeiculo.isPresent()) {
            Veiculo veiculo = optionalVeiculo.get();
            
            // Atualiza apenas os campos necessários, evitando nulos
            if (novoVeiculo.getMarca() != null) {
                veiculo.setMarca(novoVeiculo.getMarca());
            }

            if (novoVeiculo.getModelo() != null) {
                veiculo.setModelo(novoVeiculo.getModelo());
            }

            if (novoVeiculo.getAnoFabricacao() != 0) {
                veiculo.setAnoFabricacao(novoVeiculo.getAnoFabricacao());
            }

            if (novoVeiculo.getPlaca() != null) {
                veiculo.setPlaca(novoVeiculo.getPlaca());
            }

            // Salva o veículo atualizado no banco de dados
            return veiculoRepository.save(veiculo);
        } else {
            // Tratar caso o veículo não seja encontrado
            throw new IllegalArgumentException("Veículo não encontrado com o ID: " + id);
        }
    }

    public void deletarVeiculo(Long id) {
        // Verifica se o veículo existe
        Optional<Veiculo> optionalVeiculo = veiculoRepository.findById(id);
    
        if (optionalVeiculo.isPresent()) {
            Veiculo veiculo = optionalVeiculo.get();
    
            // Verifica se o veículo está associado a algum frete (exemplo)
            if (freteRepository.existsByVeiculo(veiculo)) {
                throw new IllegalStateException("Não é possível excluir o veículo, pois está associado a um frete.");
            }            
    
            // Deleta o veículo
            veiculoRepository.deleteById(id);
        } else {
            // Tratar caso o veículo não seja encontrado
            throw new IllegalArgumentException("Veículo não encontrado com o ID: " + id);
        }
    }
    
}
