package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

import java.util.UUID;

public class AtualizarCadastroMedico {

    private final RepositorioDeMedico repositorio;

    private final FiltrarMedicosPorUuid buscarMedico;

    public AtualizarCadastroMedico(RepositorioDeMedico repositorio, FiltrarMedicosPorUuid buscarMedico) {
        this.repositorio = repositorio;
        this.buscarMedico = buscarMedico;
    }

    public Medico atualizarDadosMedico(UUID uuid, Medico medico) {
        buscarMedico.findByUuid(uuid);
        return repositorio.atualizarCadastroMedico(uuid, medico);
    }
}
