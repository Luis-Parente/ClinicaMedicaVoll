package com.example.voll.medica.ClinicaMedicaVoll.config;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.usecases.*;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.medico.persistencia.RepositorioDeMedicoJpa;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.medico.persistencia.RepositorioDeMedicoJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicoConfig {

    @Bean
    AtualizarMedico atualizarCadastroMedico(RepositorioDeMedico repositorio,
                                            FiltrarMedicosPorUuid filtrarMedico) {
        return new AtualizarMedico(repositorio, filtrarMedico);
    }

    @Bean
    CadastrarMedico cadastrarMedico(RepositorioDeMedico repositorio) {
        return new CadastrarMedico(repositorio);
    }

    @Bean
    DeletarMedico deletarMedicoPorUuid(RepositorioDeMedico repositorio, FiltrarMedicosPorUuid filtrarMedicos) {
        return new DeletarMedico(repositorio, filtrarMedicos);
    }

    @Bean
    DesativarCadastroMedico desativarCadastroMedico(RepositorioDeMedico repositorio,
                                                    FiltrarMedicosPorUuid filtrarMedico) {
        return new DesativarCadastroMedico(repositorio, filtrarMedico);
    }

    @Bean
    FiltrarMedicosPorEspecialidade filtrarMedicosPorEspecialidade(RepositorioDeMedico repositorio) {
        return new FiltrarMedicosPorEspecialidade(repositorio);
    }

    @Bean
    FiltrarMedicosPorUuid filtrarMedicosPorUuid(RepositorioDeMedico repositorio) {
        return new FiltrarMedicosPorUuid(repositorio);
    }

    @Bean
    ListarMedicos listarTodosMedicos(RepositorioDeMedico repositorio) {
        return new ListarMedicos(repositorio);
    }


    @Bean
    ReativarCadastroMedico reativarCadastroMedico(RepositorioDeMedico repositorio,
                                                  FiltrarMedicosPorUuid filtrarMedico) {
        return new ReativarCadastroMedico(repositorio, filtrarMedico);
    }

    @Bean
    RepositorioDeMedicoJpaAdapter repositorioDeMedicoJ(RepositorioDeMedicoJpa repositorio) {
        return new RepositorioDeMedicoJpaAdapter(repositorio);
    }
}
