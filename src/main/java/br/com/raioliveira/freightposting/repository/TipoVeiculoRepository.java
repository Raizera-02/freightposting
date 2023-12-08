package br.com.raioliveira.freightposting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.raioliveira.freightposting.model.TipoVeiculo;

public interface TipoVeiculoRepository extends JpaRepository<TipoVeiculo, Long> {
}
