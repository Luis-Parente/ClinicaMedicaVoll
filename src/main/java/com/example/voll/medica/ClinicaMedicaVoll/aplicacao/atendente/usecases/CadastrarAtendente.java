package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

public class CadastrarAtendente {

    private final RepositorioDeAtendente repositorio;

    public CadastrarAtendente(RepositorioDeAtendente repositorio) {
        this.repositorio = repositorio;
    }

    public Atendente cadastrarNovoAtendente(Atendente atendente) {
        return repositorio.cadastrarAtendente(atendente);
    }
}
