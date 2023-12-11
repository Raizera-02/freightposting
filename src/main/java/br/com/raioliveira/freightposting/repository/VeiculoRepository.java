package br.com.raioliveira.freightposting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.raioliveira.freightposting.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    boolean existsByPlaca(String placa);
}
