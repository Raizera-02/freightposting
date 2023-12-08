package br.com.raioliveira.freightposting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.raioliveira.freightposting.model.Frete;

public interface FreteRepository extends JpaRepository<Frete, Long>{
    
}
