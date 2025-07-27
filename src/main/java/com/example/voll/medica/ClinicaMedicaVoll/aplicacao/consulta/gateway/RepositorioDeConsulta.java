package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.StatusConsulta;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioDeConsulta {

    Consulta agendarConsulta(Consulta consulta);

    void cancelarConsulta(String uuid, StatusConsulta motivoCancelamento);

    Consulta filtrarConsultaPorUuid(String uuid);

    List<Consulta> filtrarConsultasPorPaciente(String cpfPaciente);

    List<Consulta> filtrarConsultasPorMedicoEDatas(String crmMedico, LocalDate dataInicial, LocalDate dataFinal);
}
