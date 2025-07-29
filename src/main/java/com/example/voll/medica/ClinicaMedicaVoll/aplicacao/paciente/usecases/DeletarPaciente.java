package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway.RepositorioDePaciente;

public class DeletarPaciente {

    private final RepositorioDePaciente repositorio;

    private final FiltrarPacientePorCpf buscarPaciente;

    public DeletarPaciente(RepositorioDePaciente repositorio, FiltrarPacientePorCpf buscarPaciente) {
        this.repositorio = repositorio;
        this.buscarPaciente = buscarPaciente;
    }

    public void deletarPacientePorCpf(String cpf) {
        buscarPaciente.findByCpf(cpf);
        repositorio.deletarPaciente(cpf);
    }
}
