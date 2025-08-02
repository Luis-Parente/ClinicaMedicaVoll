package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.endereco.entidade;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoEntidade that = (EnderecoEntidade) o;
        return Objects.equals(logradouro, that.logradouro) && Objects.equals(numero,
                that.numero) && Objects.equals(complemento, that.complemento) && Objects.equals(cidade,
                that.cidade) && Objects.equals(uf, that.uf) && Objects.equals(cep, that.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, numero, complemento, cidade, uf, cep);
    }
}
