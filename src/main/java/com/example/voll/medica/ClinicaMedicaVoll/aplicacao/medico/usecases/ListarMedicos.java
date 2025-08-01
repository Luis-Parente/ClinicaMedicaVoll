package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

import java.util.List;

public class ListarMedicos {

    private final RepositorioDeMedico repositorio;

    public ListarMedicos(RepositorioDeMedico repositorio) {
        this.repositorio = repositorio;
    }

    public List<Medico> listarTodosMedicos() {
        return repositorio.listarTodosMedicos();
    }
}
