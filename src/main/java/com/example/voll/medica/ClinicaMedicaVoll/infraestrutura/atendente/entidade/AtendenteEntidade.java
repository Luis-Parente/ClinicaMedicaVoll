package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_atendente")
public class AtendenteEntidade {

    @Id
    private UUID uuid;

    private String nome;
    private String email;
    private String senha;

    public AtendenteEntidade() {
    }

    public AtendenteEntidade(UUID uuid, String nome, String email, String senha) {
        this.uuid = uuid;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

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
