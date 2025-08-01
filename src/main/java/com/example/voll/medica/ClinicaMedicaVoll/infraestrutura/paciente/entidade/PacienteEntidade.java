package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.paciente.entidade;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.endereco.Endereco;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.endereco.entidade.EnderecoEntidade;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "tb_paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PacienteEntidade {

    @Id
    private UUID uuid;

    private String cpf;
    private String nome;
    private String email;
    private String telefone;

    @Embedded
    private EnderecoEntidade endereco;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PacienteEntidade that = (PacienteEntidade) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }
}
