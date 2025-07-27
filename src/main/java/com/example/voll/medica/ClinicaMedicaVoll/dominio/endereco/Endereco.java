package com.example.voll.medica.ClinicaMedicaVoll.dominio.endereco;

import java.util.Objects;

public class Endereco {

    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco(String logradouro, Integer numero, String complemento, String cidade, String uf, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Boolean enderecoValido() {
        return logradouro == null || logradouro.isBlank()
                || numero == null
                || cidade == null || cidade.isBlank()
                || uf == null || uf.isBlank()
                || cep == null || cep.isBlank();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(logradouro, endereco.logradouro) && Objects.equals(numero,
                endereco.numero) && Objects.equals(complemento, endereco.complemento) && Objects.equals(
                cidade, endereco.cidade) && Objects.equals(uf, endereco.uf) && Objects.equals(cep,
                endereco.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logradouro, numero, complemento, cidade, uf, cep);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf='" + uf + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
