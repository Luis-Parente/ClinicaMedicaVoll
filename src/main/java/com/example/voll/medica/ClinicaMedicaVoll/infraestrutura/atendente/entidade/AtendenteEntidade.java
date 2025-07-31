package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_atendente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AtendenteEntidade {

    @Id
    private UUID uuid;

    private String nome;
    private String email;
    private String senha;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AtendenteEntidade that = (AtendenteEntidade) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }
}
