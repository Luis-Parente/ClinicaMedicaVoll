package com.example.voll.medica.ClinicaMedicaVoll.dominio.medico;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.endereco.Endereco;

import java.util.Objects;
import java.util.UUID;

public class Medico {

    private UUID uuid;

    private String crm;
    private String nome;
    private Especialidade especialidade;
    private String email;
    private String telefone;
    private Endereco endereco;
    private Boolean ativo;

    public Medico(UUID uuid, String crm, String nome, Especialidade especialidade, String email, String telefone,
                  Endereco endereco, Boolean ativo) {

        if (crm == null || !crm.matches("^\\d{4,8}-[A-Z]{2}$")) {
            throw new IllegalArgumentException("CRM no formato incorreto!");
        }

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome deve ser preenchido!");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("E-mail deve ser preenchido!");
        }

        if (especialidade == null) {
            throw new IllegalArgumentException("Especialidade deve ser preenchida!");
        }

        if (endereco == null || endereco.enderecoValido()) {
            throw new IllegalArgumentException("Endereco do medico está incompleto!");
        }

        this.uuid = uuid != null ? uuid : UUID.randomUUID();
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.ativo = ativo != null ? ativo : true;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void desativarCadastro() {
        this.ativo = false;
    }

    public void reativarCadastro() {
        this.ativo = true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return Objects.equals(crm, medico.crm);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(crm);
    }

    @Override
    public String toString() {
        return "Medico{" +
                "crm='" + crm + '\'' +
                ", nome='" + nome + '\'' +
                ", especialidade=" + especialidade +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                ", ativo=" + ativo +
                '}';
    }
}
