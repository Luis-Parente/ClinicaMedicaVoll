package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

public class FiltrarAtendentePorLogin {

    private final RepositorioDeAtendente repositorio;

    public FiltrarAtendentePorLogin(RepositorioDeAtendente repositorio) {
        this.repositorio = repositorio;
    }

    public Atendente findByLogin(String login) {
        return repositorio.filtrarAtendentePorLogin(login);
    }
}
