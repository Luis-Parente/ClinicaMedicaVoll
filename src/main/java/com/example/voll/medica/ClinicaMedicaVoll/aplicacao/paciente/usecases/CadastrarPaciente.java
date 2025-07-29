package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.CampoInvalidoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway.RepositorioDePaciente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;

public class CadastrarPaciente {

    private final RepositorioDePaciente repositorio;

    public CadastrarPaciente(RepositorioDePaciente repositorio) {
        this.repositorio = repositorio;
    }

    public Paciente cadastrarNovoPaciente(Paciente paciente) {
        if (repositorio.validarCpfPaciente(paciente.getCpf())) {
            throw new CampoInvalidoExcecao("Já existe paciente com esse CPF!");
        }
        return repositorio.cadastrarPaciente(paciente);
    }
}
