package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.token;

public class AtendenteToken {


    private final GerenciadorDeToken gerenciadorDeToken;

    public AtendenteToken(GerenciadorDeToken gerenciadorDeToken) {
        this.gerenciadorDeToken = gerenciadorDeToken;
    }

    public String atendenteDoToken(String token) {
        return gerenciadorDeToken.atendenteToken(token);
    }
}
