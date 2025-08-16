package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.medico.persistencia;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.medico.gateway.RepositorioDeMedico;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Especialidade;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Medico;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.medico.entidade.MedicoEntidade;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.medico.mapper.MedicoJpaMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RepositorioDeMedicoJpaAdapter implements RepositorioDeMedico {

    private final RepositorioDeMedicoJpa repositorio;

    public RepositorioDeMedicoJpaAdapter(RepositorioDeMedicoJpa repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Medico salvarMedico(Medico medico) {
        MedicoEntidade entidade = MedicoJpaMapper.paraEntidade(medico);
        return MedicoJpaMapper.paraDominio(repositorio.save(entidade));
    }

    @Override
    public Boolean validarCrmMedico(String crm) {
        return repositorio.verificaCrm(crm);
    }

    @Override
    public List<Medico> listarTodosMedicos() {
        return repositorio.findAll().stream().map(MedicoJpaMapper::paraDominio).toList();
    }

    @Override
    public List<Medico> filtrarMedicosPorEspecialidade(Especialidade especialidade) {
        return repositorio.findByEspecialidade(especialidade).stream().map(MedicoJpaMapper::paraDominio).toList();
    }

    @Override
    public Optional<Medico> filtrarMedicoPorUuid(UUID uuid) {
        return repositorio.findById(uuid).map(MedicoJpaMapper::paraDominio);
    }

    @Override
    public void deletarMedico(UUID uuid) {
        repositorio.deleteById(uuid);
    }
}
