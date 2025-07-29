package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway.RepositorioDeConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.StatusConsulta;

public class CancelarConsulta {

    private final RepositorioDeConsulta repositorio;

    private final FiltrarConsultasPorUuid buscarConsulta;

    public CancelarConsulta(RepositorioDeConsulta repositorio, FiltrarConsultasPorUuid buscarConsulta) {
        this.repositorio = repositorio;
        this.buscarConsulta = buscarConsulta;
    }

    public void cancelarConsultaPorUuid(String uuid, StatusConsulta motivoCancelamento) {
        buscarConsulta.findByUuid(uuid);
        repositorio.cancelarConsulta(uuid, motivoCancelamento);
    }
}
