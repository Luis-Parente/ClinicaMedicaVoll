package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway.RepositorioDePaciente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;

import java.util.UUID;

public class AtualizarPaciente {

    private final RepositorioDePaciente repositorio;

    private final FiltrarPacientePorUuid buscarPaciente;

    public AtualizarPaciente(RepositorioDePaciente repositorio, FiltrarPacientePorUuid buscarPaciente) {
        this.repositorio = repositorio;
        this.buscarPaciente = buscarPaciente;
    }

    public Paciente atualizarDadosPaciente(UUID uuid, Paciente pacienteAtualizado) {
        Paciente paciente = buscarPaciente.findByUuid(uuid);
        paciente.setCpf(pacienteAtualizado.getCpf());
        paciente.setNome(pacienteAtualizado.getNome());
        paciente.setEmail(pacienteAtualizado.getEmail());
        paciente.setTelefone(pacienteAtualizado.getTelefone());
        paciente.setEndereco(pacienteAtualizado.getEndereco());
        return repositorio.salvarPaciente(paciente);
    }
}
