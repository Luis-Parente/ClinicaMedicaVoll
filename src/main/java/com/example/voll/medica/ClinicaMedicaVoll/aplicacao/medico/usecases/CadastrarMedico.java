package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

public class CadastrarMedico {

    private final RepositorioDeMedico repositorio;

    public CadastrarMedico(RepositorioDeMedico repositorio) {
        this.repositorio = repositorio;
    }

    public Medico cadastrarNovoMedico(Medico medico) {
        return repositorio.cadastrarMedico(medico);
    }
}
