package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;

public class ReativarCadastroMedico {

    private final RepositorioDeMedico repositorio;

    public ReativarCadastroMedico(RepositorioDeMedico repositorio) {
        this.repositorio = repositorio;
    }

    public void reativarMedico(String crm) {
        repositorio.reativarCadastroMedico(crm);
    }
}
