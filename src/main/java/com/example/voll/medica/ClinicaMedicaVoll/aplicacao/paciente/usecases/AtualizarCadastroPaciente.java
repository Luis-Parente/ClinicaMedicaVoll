package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway.RepositorioDePaciente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;

public class AtualizarCadastroPaciente {

    private final RepositorioDePaciente repositorio;

    public AtualizarCadastroPaciente(RepositorioDePaciente repositorio) {
        this.repositorio = repositorio;
    }

    public Paciente atualizarDadosPaciente(String cpf, Paciente paciente) {
        return repositorio.atualizarCadastroPaciente(cpf, paciente);
    }
}
