package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;

public class ReativarCadastroMedico {

    private final RepositorioDeMedico repositorio;

    private final FiltrarMedicosPorCrm buscarMedico;

    public ReativarCadastroMedico(RepositorioDeMedico repositorio, FiltrarMedicosPorCrm buscarMedico) {
        this.repositorio = repositorio;
        this.buscarMedico = buscarMedico;
    }

    public void reativarMedico(String crm) {
        buscarMedico.findByCrm(crm);
        repositorio.reativarCadastroMedico(crm);
    }
}
