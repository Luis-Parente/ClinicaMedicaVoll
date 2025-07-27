package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;

public class DesativarCadastroMedico {

    private final RepositorioDeMedico repositorio;

    public DesativarCadastroMedico(RepositorioDeMedico repositorio) {
        this.repositorio = repositorio;
    }

    public void desativarMedico(String crm) {
        repositorio.desativarCadastroMedico(crm);
    }
}
