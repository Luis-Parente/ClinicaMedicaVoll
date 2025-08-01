package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.paciente.mapper;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.endereco.mapper.EnderecoJpaMapper;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.paciente.entidade.PacienteEntidade;

public class PacienteJpaMapper {

    public static Paciente paraDominio(PacienteEntidade entidade) {
        return new Paciente(entidade.getUuid(), entidade.getCpf(), entidade.getNome(), entidade.getEmail(),
                entidade.getTelefone(), EnderecoJpaMapper.paraDominio(entidade.getEndereco()));
    }

    public static PacienteEntidade paraEntidade(Paciente dominio) {
        return new PacienteEntidade(dominio.getUuid(), dominio.getCpf(), dominio.getNome(), dominio.getEmail(),
                dominio.getTelefone(), EnderecoJpaMapper.paraEntidade(dominio.getEndereco()));
    }
}
