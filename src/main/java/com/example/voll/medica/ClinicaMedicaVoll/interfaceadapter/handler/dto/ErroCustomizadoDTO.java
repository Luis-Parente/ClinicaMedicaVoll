package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.handler.dto;

import java.time.Instant;

public record ErroCustomizadoDTO(Instant timestamp, Integer status, String error, String path) {
}
