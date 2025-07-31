package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;

import java.util.UUID;

public class DesativarCadastroMedico {

    private final RepositorioDeMedico repositorio;

    private final FiltrarMedicosPorUuid buscarMedico;

    public DesativarCadastroMedico(RepositorioDeMedico repositorio, FiltrarMedicosPorUuid buscarMedico) {
        this.repositorio = repositorio;
        this.buscarMedico = buscarMedico;
    }

    public void desativarMedico(UUID uuid) {
        buscarMedico.findByUuid(uuid);
        repositorio.desativarCadastroMedico(uuid);
    }
}
