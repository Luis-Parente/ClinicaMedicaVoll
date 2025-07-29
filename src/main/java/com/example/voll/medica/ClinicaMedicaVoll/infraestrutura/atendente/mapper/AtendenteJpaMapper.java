package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.mapper;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.entidade.AtendenteEntidade;

public class AtendenteJpaMapper {

    public static Atendente paraDominio(AtendenteEntidade entidade) {
        return new Atendente(entidade.getUuid(), entidade.getNome(), entidade.getEmail(), entidade.getSenha());
    }

    public static AtendenteEntidade paraEntidade(Atendente dominio) {
        return new AtendenteEntidade(dominio.getUuid(), dominio.getNome(), dominio.getEmail(), dominio.getSenha());
    }
}
