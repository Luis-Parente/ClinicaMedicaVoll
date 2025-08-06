package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.EntidadeNaoEncontradoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

public class FiltrarAtendentePorEmail {

    private final RepositorioDeAtendente repositorio;

    public FiltrarAtendentePorEmail(RepositorioDeAtendente repositorio) {
        this.repositorio = repositorio;
    }

    public Atendente findByEmail(String email) {
        return repositorio.filtrarAtendentePorEmail(email)
                .orElseThrow(() -> new EntidadeNaoEncontradoExcecao("Atendente não encontrado!"));
    }
}
