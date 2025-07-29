package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.persistencia;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.entidade.AtendenteEntidade;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.mapper.AtendenteJpaMapper;

import java.util.Optional;
import java.util.UUID;

public class RepositorioDeAtendenteJpaAdapter implements RepositorioDeAtendente {

    private final RepositorioDeAtendenteJpa repositorio;

    public RepositorioDeAtendenteJpaAdapter(RepositorioDeAtendenteJpa repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Atendente cadastrarAtendente(Atendente atendente) {
        AtendenteEntidade entidade = AtendenteJpaMapper.paraEntidade(atendente);
        repositorio.save(entidade);
        return AtendenteJpaMapper.paraDominio(entidade);
    }

    @Override
    public Optional<Atendente> filtrarAtendentePorUuid(UUID uuid) {
        return repositorio.findById(uuid)
                .map(AtendenteJpaMapper::paraDominio);
    }

    @Override
    public Atendente atualizarCadastroAtendente(UUID uuid, Atendente atendente) {
        filtrarAtendentePorUuid(uuid);
        AtendenteEntidade entidade = AtendenteJpaMapper.paraEntidade(atendente);
        entidade.setUuid(uuid);
        repositorio.save(entidade);
        return AtendenteJpaMapper.paraDominio(entidade);
    }

    @Override
    public void deletarAtendentePorUuid(UUID uuid) {
        filtrarAtendentePorUuid(uuid);
        repositorio.deleteById(uuid);
    }
}
