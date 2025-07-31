package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.dto;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.endereco.Endereco;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Especialidade;

import java.util.UUID;

public record MedicoDTO(UUID uuid, String crm, String nome, Especialidade especialidade, String email,
                        String telefone, Endereco endereco) {
}
