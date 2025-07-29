package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway.RepositorioDePaciente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;

public class AtualizarCadastroPaciente {

    private final RepositorioDePaciente repositorio;

    private final FiltrarPacientePorCpf buscarPaciente;

    public AtualizarCadastroPaciente(RepositorioDePaciente repositorio, FiltrarPacientePorCpf buscarPaciente) {
        this.repositorio = repositorio;
        this.buscarPaciente = buscarPaciente;
    }

    public Paciente atualizarDadosPaciente(String cpf, Paciente paciente) {
        buscarPaciente.findByCpf(cpf);
        return repositorio.atualizarCadastroPaciente(cpf, paciente);
    }
}
