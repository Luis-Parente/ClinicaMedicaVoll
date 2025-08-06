package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.token;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

public class GerarToken {

    private final GerenciadorDeToken gerenciadorDeToken;

    public GerarToken(GerenciadorDeToken gerenciadorDeToken) {
        this.gerenciadorDeToken = gerenciadorDeToken;
    }

    public String gerarToken(Atendente dominio) {
        return gerenciadorDeToken.gerarToken(dominio);
    }
}
