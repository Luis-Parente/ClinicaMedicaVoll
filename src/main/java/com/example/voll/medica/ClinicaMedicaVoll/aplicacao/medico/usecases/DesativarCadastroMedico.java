package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

import java.util.UUID;

public class DesativarCadastroMedico {

    private final RepositorioDeMedico repositorio;

    private final FiltrarMedicosPorUuid buscarMedico;

    public DesativarCadastroMedico(RepositorioDeMedico repositorio, FiltrarMedicosPorUuid buscarMedico) {
        this.repositorio = repositorio;
        this.buscarMedico = buscarMedico;
    }

    public void desativarMedico(UUID uuid) {
        Medico medico = buscarMedico.findByUuid(uuid);
        medico.desativarCadastro();
        repositorio.salvarMedico(medico);
    }
}
