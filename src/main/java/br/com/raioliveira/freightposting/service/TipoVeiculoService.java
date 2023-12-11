package br.com.raioliveira.freightposting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.raioliveira.freightposting.model.TipoVeiculo;
import br.com.raioliveira.freightposting.repository.TipoVeiculoRepository;
import br.com.raioliveira.freightposting.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoVeiculoService {

    private final TipoVeiculoRepository tipoVeiculoRepository;
     private final VeiculoRepository veiculoRepository;

    @Autowired
    public TipoVeiculoService(TipoVeiculoRepository tipoVeiculoRepository, VeiculoRepository veiculoRepository) {
        this.tipoVeiculoRepository = tipoVeiculoRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public TipoVeiculo salvarTipoVeiculo(TipoVeiculo tipoVeiculo) {
        validarTipoVeiculoExistente(tipoVeiculo);
        
        return tipoVeiculoRepository.save(tipoVeiculo);
    }

    private void validarTipoVeiculoExistente(TipoVeiculo tipoVeiculo) {
        // Verifica se já existe um tipo de veículo com o mesmo nome
        if (tipoVeiculoRepository.existsByNome(tipoVeiculo.getNome())) {
            throw new IllegalArgumentException("Tipo de veículo com o nome " + tipoVeiculo.getNome() + " já cadastrado.");
        }
        
    }

    public List<TipoVeiculo> listarTodosTiposVeiculo() {
        return tipoVeiculoRepository.findAll();
    }

    public Optional<TipoVeiculo> buscarTipoVeiculoPorId(Long id) {
        return tipoVeiculoRepository.findById(id);
    }

    public void deletarTipoVeiculo(Long id) {        
        tipoVeiculoRepository.deleteById(id);
        
    }

}
