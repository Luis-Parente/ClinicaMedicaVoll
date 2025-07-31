package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.EntidadeNaoEncontradoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

import java.util.UUID;

public class FiltrarMedicosPorUuid {

    private final RepositorioDeMedico repositorio;

    public FiltrarMedicosPorUuid(RepositorioDeMedico repositorio) {
        this.repositorio = repositorio;
    }

    public Medico findByUuid(UUID uuid) {
        return repositorio.filtrarMedicoPorUuid(uuid)
                .orElseThrow(() -> new EntidadeNaoEncontradoExcecao("Medico não encontrado!"));
    }
}
