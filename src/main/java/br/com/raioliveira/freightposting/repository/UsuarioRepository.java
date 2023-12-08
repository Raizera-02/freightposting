package br.com.raioliveira.freightposting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.raioliveira.freightposting.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
