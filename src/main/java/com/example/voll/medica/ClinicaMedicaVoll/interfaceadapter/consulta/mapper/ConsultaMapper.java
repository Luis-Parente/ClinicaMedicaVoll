package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.consulta.mapper;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.consulta.dto.ConsultaDTO;

public class ConsultaMapper {

    public static Consulta paraDominio(ConsultaDTO dto) {
        return new Consulta(dto.uuid(), dto.crmMedico(), dto.cpfPaciente(), dto.dataEHora(), dto.status());
    }

    public static ConsultaDTO paraDto(Consulta dominio) {
        return new ConsultaDTO(dominio.getUuid(), dominio.getCrmMedico(), dominio.getCpfPaciente(),
                dominio.getDataEHora(), dominio.getStatus());
    }
}
