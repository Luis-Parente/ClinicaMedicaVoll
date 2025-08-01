package com.example.voll.medica.ClinicaMedicaVoll.config;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway.RepositorioDePaciente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.AtualizarPaciente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.CadastrarPaciente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.DeletarPaciente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases.FiltrarPacientePorUuid;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.paciente.persistencia.RepositorioDePacienteJpa;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.paciente.persistencia.RepositorioDePacienteJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PacienteConfig {

    @Bean
    AtualizarPaciente atualizarPaciente(RepositorioDePaciente repositorio, FiltrarPacientePorUuid buscarPaciente) {
        return new AtualizarPaciente(repositorio, buscarPaciente);
    }

    @Bean
    CadastrarPaciente cadastrarPaciente(RepositorioDePaciente repositorio) {
        return new CadastrarPaciente(repositorio);
    }

    @Bean
    DeletarPaciente deletarPaciente(RepositorioDePaciente repositorio, FiltrarPacientePorUuid buscarPaciente) {
        return new DeletarPaciente(repositorio, buscarPaciente);
    }

    @Bean
    FiltrarPacientePorUuid filtrarPacientePorUuid(RepositorioDePaciente repositorio) {
        return new FiltrarPacientePorUuid(repositorio);
    }

    @Bean
    RepositorioDePacienteJpaAdapter repositorioDePaciente(RepositorioDePacienteJpa repositorio) {
        return new RepositorioDePacienteJpaAdapter(repositorio);
    }
}
