package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.paciente.persistencia;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.paciente.gateway.RepositorioDePaciente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.paciente.Paciente;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.paciente.entidade.PacienteEntidade;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.paciente.mapper.PacienteJpaMapper;

import java.util.Optional;
import java.util.UUID;

public class RepositorioDePacienteJpaAdapter implements RepositorioDePaciente {

    private final RepositorioDePacienteJpa repositorio;

    public RepositorioDePacienteJpaAdapter(RepositorioDePacienteJpa repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Paciente salvarPaciente(Paciente dominio) {
        PacienteEntidade entidade = PacienteJpaMapper.paraEntidade(dominio);
        return PacienteJpaMapper.paraDominio(repositorio.save(entidade));
    }

    @Override
    public Boolean validarCpfPaciente(String cpf) {
        return repositorio.verificaCpf(cpf);
    }

    @Override
    public Optional<Paciente> filtrarPacientePorCpf(UUID uuid) {
        return repositorio.findById(uuid).map(PacienteJpaMapper::paraDominio);
    }

    @Override
    public void deletarPaciente(UUID uuid) {
        repositorio.deleteById(uuid);
    }
}
