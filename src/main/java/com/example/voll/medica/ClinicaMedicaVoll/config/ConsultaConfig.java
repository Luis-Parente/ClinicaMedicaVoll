package com.example.voll.medica.ClinicaMedicaVoll.config;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway.RepositorioDeConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.usecases.*;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.consulta.persistencia.RepositorioDeConsultaJpa;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.consulta.persistencia.RepositorioDeConsultaJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsultaConfig {

    @Bean
    AgendarConsulta agendarConsulta(RepositorioDeConsulta repositorio) {
        return new AgendarConsulta(repositorio);
    }

    @Bean
    CancelarConsulta cancelarConsulta(RepositorioDeConsulta repositorio, FiltrarConsultasPorUuid buscarConsulta) {
        return new CancelarConsulta(repositorio, buscarConsulta);
    }

    @Bean
    FiltrarConsultasPorMedicoEDatas filtrarConsultasPorMedicoEDatas(RepositorioDeConsulta repositorio) {
        return new FiltrarConsultasPorMedicoEDatas(repositorio);
    }

    @Bean
    FiltrarConsultasPorPaciente filtrarConsultasPorPaciente(RepositorioDeConsulta repositorio) {
        return new FiltrarConsultasPorPaciente(repositorio);
    }

    @Bean
    FiltrarConsultasPorUuid filtrarConsultasPorUuid(RepositorioDeConsulta repositorio) {
        return new FiltrarConsultasPorUuid(repositorio);
    }

    @Bean
    RepositorioDeConsultaJpaAdapter repositorioDeConsulta(RepositorioDeConsultaJpa repositorio) {
        return new RepositorioDeConsultaJpaAdapter(repositorio);
    }
}
