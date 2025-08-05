package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.mapper;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.NivelDeAcesso;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.dto.AtendenteEntradaDTO;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.atendente.dto.AtendenteRetornoDTO;

public class AtendenteMapper {

    public static Atendente paraDominio(AtendenteEntradaDTO dto) {
        return new Atendente(dto.uuid(), dto.nome(), dto.email(), dto.senha(),
                NivelDeAcesso.valueOf(dto.nivelDeAcesso()));
    }

    public static AtendenteRetornoDTO paraDto(Atendente dominio) {
        return new AtendenteRetornoDTO(dominio.getUuid().toString(), dominio.getNome(), dominio.getEmail());
    }
}
