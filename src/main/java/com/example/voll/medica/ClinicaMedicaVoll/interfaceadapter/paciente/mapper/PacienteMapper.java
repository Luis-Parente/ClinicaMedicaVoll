package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.paciente.mapper;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.endereco.mapper.EnderecoMapper;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.paciente.dto.PacienteDTO;

public class PacienteMapper {

    public static Paciente paraDominio(PacienteDTO dto) {
        return new Paciente(dto.uuid(), dto.cpf(), dto.nome(), dto.email(), dto.telefone(),
                EnderecoMapper.paraDominio(dto.endereco()));
    }

    public static PacienteDTO paraDto(Paciente dominio) {
        return new PacienteDTO(dominio.getUuid(), dominio.getCpf(), dominio.getNome(), dominio.getEmail(),
                dominio.getTelefone(), EnderecoMapper.paraDto(dominio.getEndereco()));
    }
}
