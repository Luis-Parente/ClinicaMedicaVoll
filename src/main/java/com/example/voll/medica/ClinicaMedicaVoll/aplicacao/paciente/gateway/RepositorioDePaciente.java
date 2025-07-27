package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;

public interface RepositorioDePaciente {

    Paciente cadastrarPaciente(Paciente paciente);

    Paciente filtrarPacientePorCpf(String cpf);

    Paciente atualizarCadastroPaciente(String cpf, Paciente paciente);

    void deletarPaciente(String cpf);
}
