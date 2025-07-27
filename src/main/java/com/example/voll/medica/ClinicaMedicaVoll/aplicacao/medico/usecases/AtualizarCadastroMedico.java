package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

public class AtualizarCadastroMedico {

    private final RepositorioDeMedico repositorio;

    public AtualizarCadastroMedico(RepositorioDeMedico repositorio) {
        this.repositorio = repositorio;
    }

    public Medico atualizarDadosMedico(String crm, Medico medico) {
        return repositorio.atualizarCadastroMedico(crm, medico);
    }
}
