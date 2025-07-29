package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.EntidadeNaoEncontradoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

public class FiltrarMedicosPorCrm {

    private final RepositorioDeMedico repositorio;

    public FiltrarMedicosPorCrm(RepositorioDeMedico repositorio) {
        this.repositorio = repositorio;
    }

    public Medico findByCrm(String crm) {
        return repositorio.filtrarMedicoPorCrm(crm)
                .orElseThrow(() -> new EntidadeNaoEncontradoExcecao("Medico não encontrado!"));
    }
}
