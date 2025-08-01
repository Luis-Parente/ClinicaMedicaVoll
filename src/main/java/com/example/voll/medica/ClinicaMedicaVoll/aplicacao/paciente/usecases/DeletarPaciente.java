package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway.RepositorioDePaciente;

import java.util.UUID;

public class DeletarPaciente {

    private final RepositorioDePaciente repositorio;

    private final FiltrarPacientePorUuid buscarPaciente;

    public DeletarPaciente(RepositorioDePaciente repositorio, FiltrarPacientePorUuid buscarPaciente) {
        this.repositorio = repositorio;
        this.buscarPaciente = buscarPaciente;
    }

    public void deletarPacientePorUuid(UUID uuid) {
        buscarPaciente.findByUuid(uuid);
        repositorio.deletarPaciente(uuid);
    }
}
