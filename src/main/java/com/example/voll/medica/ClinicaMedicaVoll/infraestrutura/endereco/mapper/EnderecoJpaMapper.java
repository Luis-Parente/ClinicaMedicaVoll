package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.endereco.mapper;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.endereco.Endereco;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.endereco.entidade.EnderecoEntidade;

public class EnderecoJpaMapper {

    public static Endereco paraDominio(EnderecoEntidade entidade) {
        return new Endereco(entidade.getLogradouro(), entidade.getNumero(), entidade.getComplemento(),
                entidade.getCidade(), entidade.getUf(), entidade.getCep());
    }

    public static EnderecoEntidade paraEntidade(Endereco dominio) {
        return new EnderecoEntidade(dominio.getLogradouro(), dominio.getNumero(), dominio.getComplemento(),
                dominio.getCidade(), dominio.getUf(), dominio.getCep());
    }
}
