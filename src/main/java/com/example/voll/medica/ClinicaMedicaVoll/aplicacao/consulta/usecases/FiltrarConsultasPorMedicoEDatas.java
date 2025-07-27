package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway.RepositorioDeConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;

import java.time.LocalDate;
import java.util.List;

public class FiltrarConsultasPorMedicoEDatas {

    private final RepositorioDeConsulta repositorio;

    public FiltrarConsultasPorMedicoEDatas(RepositorioDeConsulta repositorio) {
        this.repositorio = repositorio;
    }

    public List<Consulta> listarConsultasPorCrmMedicoEDatas(String crmMedico, LocalDate dataInicial,
                                                            LocalDate dataFinal) {
        return repositorio.filtrarConsultasPorMedicoEDatas(crmMedico, dataInicial, dataFinal);
    }
}
