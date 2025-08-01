package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

import java.util.UUID;

public class AtualizarAtendente {

    private final RepositorioDeAtendente repositorio;

    private final FiltrarAtendentePorUuid buscarAtendente;

    public AtualizarAtendente(RepositorioDeAtendente repositorio, FiltrarAtendentePorUuid buscarAtendente) {
        this.repositorio = repositorio;
        this.buscarAtendente = buscarAtendente;
    }

    public Atendente atualizarDadosAtendente(UUID uuid, Atendente atendente) {
        buscarAtendente.findByUuid(uuid);
        return repositorio.atualizarCadastroAtendente(uuid, atendente);
    }
}
