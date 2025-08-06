package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.token;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

public interface GerenciadorDeToken {

    String gerarToken(Atendente atendente);

    String autenticarToken(String token);

    String atendenteToken(String token);

    String funcaoToken(String token);
}
