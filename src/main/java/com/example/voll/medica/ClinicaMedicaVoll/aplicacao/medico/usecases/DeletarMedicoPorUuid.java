package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;

import java.util.UUID;

public class DeletarMedicoPorUuid {

    private final RepositorioDeMedico repositorio;

    private final FiltrarMedicosPorUuid buscarMedico;

    public DeletarMedicoPorUuid(RepositorioDeMedico repositorio, FiltrarMedicosPorUuid buscarMedico) {
        this.repositorio = repositorio;
        this.buscarMedico = buscarMedico;
    }

    public void deletarMedicoPorUuid(UUID uuid) {
        buscarMedico.findByUuid(uuid);
        repositorio.deletarMedico(uuid);
    }
}
