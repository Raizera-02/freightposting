package br.com.raioliveira.freightposting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "tb_frete")
public class Frete {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFrete;

    @ManyToOne
    private Veiculo veiculo;

    @ManyToOne
    private TipoVeiculo tipoVeiculo;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Usuario usuario;

    private double distanciaKm;
    private double valorFrete;
    private double taxa;
    private String statusFrete;
}
