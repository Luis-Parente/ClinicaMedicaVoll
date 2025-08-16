package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.StatusConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositorioDeConsulta {

    Consulta salvarConsulta(Consulta dominio);

    Boolean validarDataConsulta(LocalDateTime dataEHora);

    Optional<Consulta> filtrarConsultaPorUuid(UUID uuid);

    List<Consulta> filtrarConsultasPorPaciente(String cpfPaciente);

    List<Consulta> filtrarConsultasPorMedicoEDatas(String crmMedico, LocalDate dataInicial, LocalDate dataFinal);
}
