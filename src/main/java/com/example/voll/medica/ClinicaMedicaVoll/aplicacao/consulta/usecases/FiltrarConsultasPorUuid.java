package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway.RepositorioDeConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.EntidadeNaoEncontradoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;

import java.util.UUID;

public class FiltrarConsultasPorUuid {

    private final RepositorioDeConsulta repositorio;

    public FiltrarConsultasPorUuid(RepositorioDeConsulta repositorio) {
        this.repositorio = repositorio;
    }

    public Consulta findByUuid(UUID uuid) {
        return repositorio.filtrarConsultaPorUuid(uuid)
                .orElseThrow(() -> new EntidadeNaoEncontradoExcecao("Consulta nào encontrada!"));
    }
}
