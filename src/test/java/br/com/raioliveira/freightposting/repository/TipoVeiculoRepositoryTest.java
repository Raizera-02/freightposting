package br.com.raioliveira.freightposting.repository;

import br.com.raioliveira.freightposting.model.TipoVeiculo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class TipoVeiculoRepositoryTest {

    @Autowired
    private TipoVeiculoRepository tipoVeiculoRepository;

    @Test
    public void testSalvarTipoVeiculo() {
        TipoVeiculo tipoVeiculo = new TipoVeiculo();
        tipoVeiculo.setNome("Caminhão");
        tipoVeiculo.setPesoCalculo(2.5);

        tipoVeiculoRepository.save(tipoVeiculo);

        assertNotNull(tipoVeiculo.getIdTipoVeiculo());
    }
}
