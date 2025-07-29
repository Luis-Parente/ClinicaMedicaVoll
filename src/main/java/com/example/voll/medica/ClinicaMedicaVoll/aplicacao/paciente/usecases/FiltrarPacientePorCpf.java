package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.EntidadeNaoEncontradoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway.RepositorioDePaciente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;

public class FiltrarPacientePorCpf {

    private final RepositorioDePaciente repositorio;

    public FiltrarPacientePorCpf(RepositorioDePaciente repositorio) {
        this.repositorio = repositorio;
    }

    public Paciente findByCpf(String cpf) {
        return repositorio.filtrarPacientePorCpf(cpf)
                .orElseThrow(() -> new EntidadeNaoEncontradoExcecao("Paciente não encontrado!"));
    }
}
