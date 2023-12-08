package br.com.raioliveira.freightposting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity (name = "tb_tipo_veiculo")
public class TipoVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoVeiculo;

    private String nome;
    private double pesoCalculo;  
    
}
