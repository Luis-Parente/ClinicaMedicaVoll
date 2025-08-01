package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;

import java.util.Optional;
import java.util.UUID;

public interface RepositorioDePaciente {

    Paciente cadastrarPaciente(Paciente paciente);

    Boolean validarCpfPaciente(String cpf);

    Optional<Paciente> filtrarPacientePorCpf(UUID uuid);

    Paciente atualizarCadastroPaciente(UUID uuid, Paciente paciente);

    void deletarPaciente(UUID uuid);
}
