package com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.endereco.Endereco;

import java.util.Objects;

public class Paciente {

    private String cpf;

    private String nome;
    private String email;
    private String telefone;
    private Endereco endereco;

    public Paciente(String cpf, String nome, String email, String telefone, Endereco endereco) {

        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF no formato incorreto!");
        }

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome deve ser preenchido");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("E-mail deve ser preenchido");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(cpf, paciente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
