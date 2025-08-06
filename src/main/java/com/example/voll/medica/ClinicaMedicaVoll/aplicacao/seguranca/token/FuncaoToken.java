package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.token;

public class FuncaoToken {


    private final GerenciadorDeToken gerenciadorDeToken;

    public FuncaoToken(GerenciadorDeToken gerenciadorDeToken) {
        this.gerenciadorDeToken = gerenciadorDeToken;
    }

    public String funcaoDoToken(String token) {
        return gerenciadorDeToken.funcaoToken(token);
    }
}
