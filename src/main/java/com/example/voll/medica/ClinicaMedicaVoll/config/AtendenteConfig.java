package com.example.voll.medica.ClinicaMedicaVoll.config;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.AtualizarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.CadastrarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.DeletarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.FiltrarAtendente;
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
    FiltrarAtendente filtrarAtendentePorUuid(RepositorioDeAtendente repositorio) {
        return new FiltrarAtendente(repositorio);
    }

    @Bean
    AtualizarAtendente atualizarCadastroAtendente(RepositorioDeAtendente repositorio, FiltrarAtendente filtrarAtendente) {
        return new AtualizarAtendente(repositorio, filtrarAtendente);
    }

    @Bean
    DeletarAtendente deletarAtendentePorUuid(RepositorioDeAtendente repositorio,  FiltrarAtendente filtrarAtendente) {
        return new DeletarAtendente(repositorio, filtrarAtendente);
    }

    @Bean
    RepositorioDeAtendenteJpaAdapter repositorioDeAtendente(RepositorioDeAtendenteJpa repositorio) {
        return new RepositorioDeAtendenteJpaAdapter(repositorio);
    }
}
