package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.consulta.dto;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.StatusConsulta;

import java.time.LocalDateTime;
import java.util.UUID;

public record ConsultaDTO(UUID uuid, String crmMedico, String cpfPaciente, LocalDateTime dataEHora,
                          StatusConsulta status) {
}
