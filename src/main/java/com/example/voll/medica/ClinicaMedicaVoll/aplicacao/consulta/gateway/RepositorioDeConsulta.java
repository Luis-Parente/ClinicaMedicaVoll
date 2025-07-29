package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.StatusConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface RepositorioDeConsulta {

    Consulta agendarConsulta(Consulta consulta);

    Boolean validarDataConsulta(LocalDateTime dataEHora);

    void cancelarConsulta(String uuid, StatusConsulta motivoCancelamento);

    Optional<Consulta> filtrarConsultaPorUuid(String uuid);

    List<Consulta> filtrarConsultasPorPaciente(String cpfPaciente);

    List<Consulta> filtrarConsultasPorMedicoEDatas(String crmMedico, LocalDate dataInicial, LocalDate dataFinal);
}
