package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway.RepositorioDeConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class FiltrarConsultasPorMedicoEDatas {

    private final RepositorioDeConsulta repositorio;

    public FiltrarConsultasPorMedicoEDatas(RepositorioDeConsulta repositorio) {
        this.repositorio = repositorio;
    }

    public List<Consulta> listarConsultasPorCrmMedicoEDatas(String crmMedico, LocalDate dataInicial,
                                                            LocalDate dataFinal) {
        if (dataInicial == null) {
            dataInicial = LocalDate.now().withDayOfMonth(1);
        }

        if (dataFinal == null) {
            dataFinal = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        }

        return repositorio.filtrarConsultasPorMedicoEDatas(crmMedico, dataInicial, dataFinal.plusDays(1));
    }
}
