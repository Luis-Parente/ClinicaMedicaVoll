package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

public class AtualizarCadastroAtendente {

    private final RepositorioDeAtendente repositorio;

    public AtualizarCadastroAtendente(RepositorioDeAtendente repositorio){
        this.repositorio = repositorio;
    }

    public Atendente atualizarDadosAtendente(Atendente atendente){
        return repositorio.atualizarCadastroAtendente(atendente);
    }
}
