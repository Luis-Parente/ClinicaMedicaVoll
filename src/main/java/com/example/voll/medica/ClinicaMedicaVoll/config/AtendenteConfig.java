package com.example.voll.medica.ClinicaMedicaVoll.config;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.AtualizarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.CadastrarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.DeletarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.FiltrarAtendentePorUuid;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.persistencia.RepositorioDeAtendenteJpa;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.persistencia.RepositorioDeAtendenteJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtendenteConfig {

    @Bean
    CadastrarAtendente cadastrarAtendente(RepositorioDeAtendente repositorio) {
        return new CadastrarAtendente(repositorio);
    }

    @Bean
    FiltrarAtendentePorUuid filtrarAtendentePorUuid(RepositorioDeAtendente repositorio) {
        return new FiltrarAtendentePorUuid(repositorio);
    }

    @Bean
    AtualizarAtendente atualizarCadastroAtendente(RepositorioDeAtendente repositorio, FiltrarAtendentePorUuid filtrarAtendentePorUuid) {
        return new AtualizarAtendente(repositorio, filtrarAtendentePorUuid);
    }

    @Bean
    DeletarAtendente deletarAtendentePorUuid(RepositorioDeAtendente repositorio,  FiltrarAtendentePorUuid filtrarAtendentePorUuid) {
        return new DeletarAtendente(repositorio, filtrarAtendentePorUuid);
    }

    @Bean
    RepositorioDeAtendenteJpaAdapter repositorioDeAtendente(RepositorioDeAtendenteJpa repositorio) {
        return new RepositorioDeAtendenteJpaAdapter(repositorio);
    }
}
