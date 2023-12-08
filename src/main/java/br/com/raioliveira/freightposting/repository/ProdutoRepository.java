package br.com.raioliveira.freightposting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.raioliveira.freightposting.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
