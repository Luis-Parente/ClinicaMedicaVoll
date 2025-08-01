package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.consulta.persistencia;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.consulta.gateway.RepositorioDeConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.Consulta;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.StatusConsulta;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.consulta.entidade.ConsultaEntidade;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.consulta.mapper.ConsultaJpaMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RepositorioDeConsultaJpaAdapter implements RepositorioDeConsulta {

    private final RepositorioDeConsultaJpa repositorio;

    public RepositorioDeConsultaJpaAdapter(RepositorioDeConsultaJpa repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Consulta agendarConsulta(Consulta dominio) {
        ConsultaEntidade entidade = ConsultaJpaMapper.paraEntidade(dominio);
        repositorio.save(entidade);
        return ConsultaJpaMapper.paraDominio(entidade);
    }

    @Override
    public Boolean validarDataConsulta(LocalDateTime dataEHora) {
        return repositorio.verificaData(dataEHora);
    }

    @Override
    public void cancelarConsulta(UUID uuid, StatusConsulta motivoCancelamento) {
        Optional<Consulta> dominio = filtrarConsultaPorUuid(uuid);
        ConsultaEntidade entidade = ConsultaJpaMapper.paraEntidade(dominio.get());
        entidade.setStatus(motivoCancelamento);
        repositorio.save(entidade);
    }

    @Override
    public Optional<Consulta> filtrarConsultaPorUuid(UUID uuid) {
        return repositorio.findById(uuid).map(ConsultaJpaMapper::paraDominio);
    }

    @Override
    public List<Consulta> filtrarConsultasPorPaciente(String cpfPaciente) {
        return repositorio.findAllByCpfPaciente(cpfPaciente).stream().map(ConsultaJpaMapper::paraDominio).toList();
    }

    @Override
    public List<Consulta> filtrarConsultasPorMedicoEDatas(String crmMedico, LocalDate dataInicial,
                                                          LocalDate dataFinal) {
        return repositorio.findAllByCrmAndDate(crmMedico, dataInicial, dataFinal).stream()
                .map(ConsultaJpaMapper::paraDominio).toList();
    }
}
