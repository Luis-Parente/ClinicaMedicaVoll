package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.criptografador;

public class CriptografarSenha {

    private final CriptografadorDeSenha criptografadorDeSenha;

    public CriptografarSenha(CriptografadorDeSenha criptografadorDeSenha) {
        this.criptografadorDeSenha = criptografadorDeSenha;
    }

    public String criptografarSenha(String senha) {
        return criptografadorDeSenha.criptografarSenha(senha);
    }
}
