package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway.RepositorioDeConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.StatusConsulta;

public class CancelarConsulta {

    private final RepositorioDeConsulta repositorio;

    public CancelarConsulta(RepositorioDeConsulta repositorio) {
        this.repositorio = repositorio;
    }

    public Consulta cancelarConsultaPorUuid(StatusConsulta motivoCancelamento, String uuid) {
        repositorio.cancelarConsulta(motivoCancelamento, uuid);
    }
}
