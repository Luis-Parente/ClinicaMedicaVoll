package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.medico.mapper;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.endereco.mapper.EnderecoJpaMapper;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.medico.entidade.MedicoEntidade;

public class MedicoJpaMapper {

    public static Medico paraDominio(MedicoEntidade entidade) {
        return new Medico(entidade.getUuid(), entidade.getCrm(), entidade.getNome(), entidade.getEspecialidade(),
                entidade.getEmail(),
                entidade.getTelefone(), EnderecoJpaMapper.paraDominio(entidade.getEndereco()), entidade.getAtivo());
    }

    public static MedicoEntidade paraEntidade(Medico dominio) {
        return new MedicoEntidade(dominio.getUuid(), dominio.getCrm(), dominio.getNome(), dominio.getEspecialidade(),
                dominio.getEmail(),
                dominio.getTelefone(), EnderecoJpaMapper.paraEntidade(dominio.getEndereco()), dominio.getAtivo());
    }
}
