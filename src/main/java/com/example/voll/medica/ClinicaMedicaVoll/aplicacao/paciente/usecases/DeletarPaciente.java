package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway.RepositorioDePaciente;

public class DeletarPaciente {

    private final RepositorioDePaciente repositorio;

    public DeletarPaciente(RepositorioDePaciente repositorio) {
        this.repositorio = repositorio;
    }

    public void deletarPacientePorCpf(String cpf) {
        repositorio.deletarPaciente(cpf);
    }
}
