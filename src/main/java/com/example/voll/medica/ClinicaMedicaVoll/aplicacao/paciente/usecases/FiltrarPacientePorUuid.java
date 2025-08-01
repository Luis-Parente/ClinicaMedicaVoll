package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.EntidadeNaoEncontradoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway.RepositorioDePaciente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;

import java.util.UUID;

public class FiltrarPacientePorUuid {

    private final RepositorioDePaciente repositorio;

    public FiltrarPacientePorUuid(RepositorioDePaciente repositorio) {
        this.repositorio = repositorio;
    }

    public Paciente findByUuid(UUID uuid) {
        return repositorio.filtrarPacientePorCpf(uuid)
                .orElseThrow(() -> new EntidadeNaoEncontradoExcecao("Paciente não encontrado!"));
    }
}
