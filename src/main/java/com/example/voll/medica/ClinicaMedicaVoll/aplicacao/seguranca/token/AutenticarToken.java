package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.token;

public class AutenticarToken {

    private final GerenciadorDeToken gerenciadorDeToken;

    public AutenticarToken(GerenciadorDeToken gerenciadorDeToken) {
        this.gerenciadorDeToken = gerenciadorDeToken;
    }

    public String autenticarToken(String token) {
        return gerenciadorDeToken.autenticarToken(token);
    }
}
