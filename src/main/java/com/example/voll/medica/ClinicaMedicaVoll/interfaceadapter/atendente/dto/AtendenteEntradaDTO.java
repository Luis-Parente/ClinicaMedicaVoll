package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.dto;

import java.util.UUID;

public record AtendenteEntradaDTO(UUID uuid, String nome, String email, String senha, String nivelDeAcesso) {
}
