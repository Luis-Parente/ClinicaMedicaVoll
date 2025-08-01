package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.EntidadeNaoEncontradoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

import java.util.UUID;

public class FiltrarAtendentePorUuid {

    private final RepositorioDeAtendente repositorio;

    public FiltrarAtendentePorUuid(RepositorioDeAtendente repositorio) {
        this.repositorio = repositorio;
    }

    public Atendente findByUuid(UUID uuid) {
        return repositorio.filtrarAtendentePorUuid(uuid)
                .orElseThrow(() -> new EntidadeNaoEncontradoExcecao("Atendente não encontrado!"));
    }
}
