package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;

public class DesativarCadastroMedico {

    private final RepositorioDeMedico repositorio;

    private final FiltrarMedicosPorCrm buscarMedico;

    public DesativarCadastroMedico(RepositorioDeMedico repositorio, FiltrarMedicosPorCrm buscarMedico) {
        this.repositorio = repositorio;
        this.buscarMedico = buscarMedico;
    }

    public void desativarMedico(String crm) {
        buscarMedico.findByCrm(crm);
        repositorio.desativarCadastroMedico(crm);
    }
}
