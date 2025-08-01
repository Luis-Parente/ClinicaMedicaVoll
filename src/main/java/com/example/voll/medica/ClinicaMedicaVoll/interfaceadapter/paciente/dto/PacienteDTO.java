package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.paciente.dto;

import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.endereco.dto.EnderecoDTO;

import java.util.UUID;

public record PacienteDTO(UUID uuid, String cpf, String nome, String email, String telefone, EnderecoDTO endereco) {
}
