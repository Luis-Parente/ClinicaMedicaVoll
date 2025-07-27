package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway.RepositorioDeConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;

public class FiltrarConsultasPorUuid {

    private final RepositorioDeConsulta repositorio;

    public FiltrarConsultasPorUuid(RepositorioDeConsulta repositorio) {
        this.repositorio = repositorio;
    }

    public Consulta findByUuid(String uuid) {
        return repositorio.filtrarConsultaPorUuid(uuid);
    }
}
