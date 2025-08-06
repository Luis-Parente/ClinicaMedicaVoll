package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.criptografador.CriptografarSenha;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

import java.util.UUID;

public class AtualizarAtendente {

    private final RepositorioDeAtendente repositorio;

    private final FiltrarAtendentePorUuid buscarAtendente;

    private final CriptografarSenha criptografarSenha;

    public AtualizarAtendente(RepositorioDeAtendente repositorio, FiltrarAtendentePorUuid buscarAtendente,
                              CriptografarSenha criptografarSenha) {
        this.repositorio = repositorio;
        this.buscarAtendente = buscarAtendente;
        this.criptografarSenha = criptografarSenha;
    }

    public Atendente atualizarDadosAtendente(UUID uuid, Atendente atendente) {
        buscarAtendente.findByUuid(uuid);
        atendente.setSenha(criptografarSenha.criptografarSenha(atendente.getSenha()));
        return repositorio.atualizarCadastroAtendente(uuid, atendente);
    }
}
