package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.consulta.mapper;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.consulta.entidade.ConsultaEntidade;

public class ConsultaJpaMapper {

    public static Consulta paraDominio(ConsultaEntidade entidade) {
        return new Consulta(entidade.getUuid(), entidade.getCrmMedico(), entidade.getCpfPaciente(),
                entidade.getDataEHora(), entidade.getStatus());
    }

    public static ConsultaEntidade paraEntidade(Consulta dominio) {
        return new ConsultaEntidade(dominio.getUuid(), dominio.getCrmMedico(), dominio.getCpfPaciente(),
                dominio.getDataEHora(), dominio.getStatus());
    }
}
