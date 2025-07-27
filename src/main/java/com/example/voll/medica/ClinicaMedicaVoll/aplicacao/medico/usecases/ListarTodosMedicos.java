package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

import java.util.List;

public class ListarTodosMedicos {

    private final RepositorioDeMedico repositorio;

    public ListarTodosMedicos(RepositorioDeMedico repositorio) {
        this.repositorio = repositorio;
    }

    public List<Medico> listarMedicos() {
        return repositorio.listarTodosMedicos();
    }
}
