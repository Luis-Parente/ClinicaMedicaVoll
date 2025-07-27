package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway.RepositorioDeConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;

import java.util.List;

public class FiltrarConsultasPorPaciente {

    private final RepositorioDeConsulta repositorio;

    public FiltrarConsultasPorPaciente(RepositorioDeConsulta repositorio) {
        this.repositorio = repositorio;
    }

    public List<Consulta> listarConsultasPorCpfPaciente(String cpfPaciente) {
        return repositorio.filtrarConsultasPorPaciente(cpfPaciente);
    }
}
