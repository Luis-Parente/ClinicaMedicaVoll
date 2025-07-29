package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;

public class DeletarAtendentePorUuid {

    private final RepositorioDeAtendente repositorio;

    private final FiltrarAtendentePorUuid buscarAtendente;

    public DeletarAtendentePorUuid(RepositorioDeAtendente repositorio, FiltrarAtendentePorUuid buscarAtendente) {
        this.repositorio = repositorio;
        this.buscarAtendente = buscarAtendente;
    }

    public void deletarAtendente(String uuid) {
        buscarAtendente.findByUuid(uuid);
        repositorio.deletarAtendentePorUuid(uuid);
    }
}
