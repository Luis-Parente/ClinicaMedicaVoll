package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;

public class DeletarAtendentePorUuid {

    private final RepositorioDeAtendente repositorio;

    public DeletarAtendentePorUuid(RepositorioDeAtendente repositorio){
        this.repositorio = repositorio;
    }

    public void deletarAtendente(String uuid){
        repositorio.deletarAtendentePorUuid(uuid);
    }
}
