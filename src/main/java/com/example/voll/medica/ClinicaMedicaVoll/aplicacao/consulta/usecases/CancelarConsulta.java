package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway.RepositorioDeConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.StatusConsulta;

import java.util.UUID;

public class CancelarConsulta {

    private final RepositorioDeConsulta repositorio;

    private final FiltrarConsultasPorUuid buscarConsulta;

    public CancelarConsulta(RepositorioDeConsulta repositorio, FiltrarConsultasPorUuid buscarConsulta) {
        this.repositorio = repositorio;
        this.buscarConsulta = buscarConsulta;
    }

    public void cancelarConsultaPorUuid(UUID uuid, StatusConsulta motivoCancelamento) {
        Consulta consulta = buscarConsulta.findByUuid(uuid);
        consulta.setStatus(motivoCancelamento);
        repositorio.salvarConsulta(consulta);
    }
}
