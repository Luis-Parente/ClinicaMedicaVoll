package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Especialidade;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RepositorioDeMedico {

    Medico salvarMedico(Medico medico);

    Boolean validarCrmMedico(String crm);

    List<Medico> listarTodosMedicos();

    List<Medico> filtrarMedicosPorEspecialidade(Especialidade especialidade);

    Optional<Medico> filtrarMedicoPorUuid(UUID uuid);

    void deletarMedico(UUID uuid);
}
