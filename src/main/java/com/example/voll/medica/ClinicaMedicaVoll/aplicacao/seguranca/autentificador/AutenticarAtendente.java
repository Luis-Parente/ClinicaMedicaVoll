package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.autentificador;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

public class AutenticarAtendente {

    private final AutenticadorDeAtendente autenticadorDeAtendente;

    public AutenticarAtendente(AutenticadorDeAtendente autenticadorDeAtendente) {
        this.autenticadorDeAtendente = autenticadorDeAtendente;
    }

    public Atendente autenticar(String email, String senha) {
        return autenticadorDeAtendente.autenticar(email, senha);
    }
}
