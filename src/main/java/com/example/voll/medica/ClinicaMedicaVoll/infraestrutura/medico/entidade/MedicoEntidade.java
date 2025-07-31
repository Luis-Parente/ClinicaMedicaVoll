package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.medico.entidade;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Especialidade;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.endereco.entidade.EnderecoEntidade;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MedicoEntidade {

    @Id
    private UUID uuid;

    @Column(unique = true)
    private String crm;
    private String nome;
    private Especialidade especialidade;
    private String email;
    private String telefone;

    @Embedded
    private EnderecoEntidade endereco;
    private Boolean ativo;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MedicoEntidade that = (MedicoEntidade) o;
        return Objects.equals(crm, that.crm);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(crm);
    }
}
