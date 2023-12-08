package br.com.raioliveira.freightposting.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.raioliveira.freightposting.model.Veiculo;

@DataJpaTest
public class VeiculoRepositoryTest {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Test
    public void testSalvarVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("Toyota");
        veiculo.setModelo("Corolla");
        veiculo.setAnoFabricacao(2022);
        veiculo.setPlaca("ABC123");

        veiculoRepository.save(veiculo);

        // Adicione asserções ou logs para verificar se o veículo foi salvo corretamente.
    }
}
