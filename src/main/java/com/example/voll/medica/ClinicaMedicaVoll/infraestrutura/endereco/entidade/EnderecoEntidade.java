package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.endereco.entidade;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EnderecoEntidade {
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;
}
