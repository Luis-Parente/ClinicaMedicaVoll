package com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente;

import java.util.Objects;
import java.util.UUID;

public class Atendente {

    private UUID uuid;

    private String nome;
    private String email;
    private String senha;

    public Atendente(UUID uuid, String nome, String email, String senha) {

        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Nome deve ser preenchido!");
        }

        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("E-mail deve ser preenchido!");
        }

        if(senha == null || senha.isBlank()){
            throw new IllegalArgumentException("Senha deve ser preenchida!");
        }

        this.uuid = uuid != null ? uuid : UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public UUID getUuid() {
        return uuid;
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
        Atendente atendente = (Atendente) o;
        return Objects.equals(uuid, atendente.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    @Override
    public String toString() {
        return "Atendente{" +
                "uuid=" + uuid +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
