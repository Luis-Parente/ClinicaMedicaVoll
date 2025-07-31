package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.mapper;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.dto.MedicoDTO;

public class MedicoMapper {

    public static Medico paraDominio(MedicoDTO dto) {
        return new Medico(dto.uuid(), dto.crm(), dto.nome(), dto.especialidade(), dto.email(), dto.telefone(),
                dto.endereco());
    }

    public static MedicoDTO paraDto(Medico dominio) {
        return new MedicoDTO(dominio.getUuid(), dominio.getCrm(), dominio.getNome(), dominio.getEspecialidade(),
                dominio.getEmail(), dominio.getTelefone(), dominio.getEndereco());
    }
}
