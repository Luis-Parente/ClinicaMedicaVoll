package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

import java.util.UUID;

public class AtualizarMedico {

    private final RepositorioDeMedico repositorio;

    private final FiltrarMedicosPorUuid buscarMedico;

    public AtualizarMedico(RepositorioDeMedico repositorio, FiltrarMedicosPorUuid buscarMedico) {
        this.repositorio = repositorio;
        this.buscarMedico = buscarMedico;
    }

    public Medico atualizarDadosMedico(UUID uuid, Medico medicoAtualizado) {
        Medico medico = buscarMedico.findByUuid(uuid);
        medico.setCrm(medicoAtualizado.getCrm());
        medico.setNome(medicoAtualizado.getNome());
        medico.setEspecialidade(medicoAtualizado.getEspecialidade());
        medico.setEmail(medicoAtualizado.getEmail());
        medico.setTelefone(medicoAtualizado.getTelefone());
        medico.setEndereco(medicoAtualizado.getEndereco());
        return repositorio.salvarMedico(medico);
    }
}
