package br.com.raioliveira.freightposting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "tb_veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVeiculo;

    private String marca;
    private String modelo;
    private int anoFabricacao;
    private String placa;

    @ManyToOne
    @JoinColumn(name = "tipo_veiculo_id")
    private TipoVeiculo tipoVeiculo;

}
