package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.dto;

import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.endereco.dto.EnderecoDTO;

import java.util.UUID;

public record MedicoDTO(UUID uuid, String crm, String nome, String especialidade, String email,
                        String telefone, EnderecoDTO endereco, Boolean ativo) {
}
