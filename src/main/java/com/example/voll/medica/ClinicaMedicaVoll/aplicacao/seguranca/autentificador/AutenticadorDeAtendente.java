package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.autentificador;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

public interface AutenticadorDeAtendente {

    Atendente autenticar(String email, String senha);
}
