package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

import java.util.List;
import java.util.Optional;

public interface RepositorioDeMedico {

    Medico cadastrarMedico(Medico medico);

    Boolean validarCrmMedico(String crm);

    List<Medico> listarTodosMedicos();

    List<Medico> filtrarMedicosPorEspecialidade(String especialidade);

    Optional<Medico> filtrarMedicoPorCrm(String crm);

    Medico atualizarCadastroMedico(String crm, Medico medico);

    void desativarCadastroMedico(String crmMedico);

    void reativarCadastroMedico(String crmMedico);
}
