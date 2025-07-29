package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway.RepositorioDeConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.CampoInvalidoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;

public class AgendarConsulta {

    private final RepositorioDeConsulta repositorio;

    public AgendarConsulta(RepositorioDeConsulta repositorio) {
        this.repositorio = repositorio;
    }

    public Consulta salvarNovaConsulta(Consulta consulta) {
        if (repositorio.validarDataConsulta(consulta.getDataEHora())) {
            throw new CampoInvalidoExcecao("Ja existe consulta nessa data!");
        }
        return repositorio.agendarConsulta(consulta);
    }
}
