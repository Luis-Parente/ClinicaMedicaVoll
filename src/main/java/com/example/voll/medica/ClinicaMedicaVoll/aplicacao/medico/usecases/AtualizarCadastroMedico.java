package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

public class AtualizarCadastroMedico {

    private final RepositorioDeMedico repositorio;

    private final FiltrarMedicosPorCrm buscarMedico;

    public AtualizarCadastroMedico(RepositorioDeMedico repositorio, FiltrarMedicosPorCrm buscarMedico) {
        this.repositorio = repositorio;
        this.buscarMedico = buscarMedico;
    }

    public Medico atualizarDadosMedico(String crm, Medico medico) {
        buscarMedico.findByCrm(crm);
        return repositorio.atualizarCadastroMedico(crm, medico);
    }
}
