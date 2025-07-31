package com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.mapper;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Especialidade;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.endereco.mapper.EnderecoMapper;
import com.example.voll.medica.ClinicaMedicaVoll.interfaceadapter.medico.dto.MedicoDTO;

public class MedicoMapper {

    public static Medico paraDominio(MedicoDTO dto) {
        return new Medico(dto.uuid(), dto.crm(), dto.nome(), Especialidade.valueOf(dto.especialidade()), dto.email(),
                dto.telefone(),
                EnderecoMapper.paraDominio(dto.endereco()), dto.ativo());
    }

    public static MedicoDTO paraDto(Medico dominio) {
        return new MedicoDTO(dominio.getUuid(), dominio.getCrm(), dominio.getNome(),
                dominio.getEspecialidade().toString(),
                dominio.getEmail(), dominio.getTelefone(), EnderecoMapper.paraDto(dominio.getEndereco()),
                dominio.getAtivo());
    }
}
