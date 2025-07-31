package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Especialidade;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

import java.util.List;

public class FiltrarMedicosPorEspecialidade {

    private final RepositorioDeMedico repositorio;

    public FiltrarMedicosPorEspecialidade(RepositorioDeMedico repositorio) {
        this.repositorio = repositorio;
    }

    public List<Medico> listarMedicosPorEspecialidade(Especialidade especialidade) {
        return repositorio.filtrarMedicosPorEspecialidade(especialidade);
    }
}
