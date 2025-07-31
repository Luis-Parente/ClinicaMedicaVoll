package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.medico.persistencia;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.medico.Especialidade;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.medico.entidade.MedicoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RepositorioDeMedicoJpa extends JpaRepository<MedicoEntidade, UUID> {

    @Query(nativeQuery = true, value = "SELECT EXISTS (SELECT 1 FROM tb_medico WHERE crm = :crm)")
    Boolean verificaCrm(String crm);

    List<MedicoEntidade> findByEspecialidade(Especialidade especialidade);
}
