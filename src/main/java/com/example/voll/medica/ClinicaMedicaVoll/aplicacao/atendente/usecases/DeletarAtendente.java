package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;

import java.util.UUID;

public class DeletarAtendente {

    private final RepositorioDeAtendente repositorio;

    private final FiltrarAtendentePorUuid buscarAtendente;

    public DeletarAtendente(RepositorioDeAtendente repositorio, FiltrarAtendentePorUuid buscarAtendente) {
        this.repositorio = repositorio;
        this.buscarAtendente = buscarAtendente;
    }

    public void deletarAtendentePorUuid(UUID uuid) {
        buscarAtendente.findByUuid(uuid);
        repositorio.deletarAtendentePorUuid(uuid);
    }
}
