package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

import java.util.List;

public interface RepositorioDeMedico {

    Medico cadastrarMedico(Medico medico);

    List<Medico> listarTodosMedicos();

    List<Medico> filtrarMedicosPorEspecialidade(String especialidade);

    Medico filtrarMedicoPorCrm(String crm);

    Medico atualizarCadastroMedico(String crm, Medico medico);

    void desativarCadastroMedico(String crmMedico);

    void reativarCadastroMedico(String crmMedico);
}
