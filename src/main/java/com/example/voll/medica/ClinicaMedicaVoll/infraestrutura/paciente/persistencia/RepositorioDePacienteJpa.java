package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.paciente.persistencia;

import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.paciente.entidade.PacienteEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface RepositorioDePacienteJpa extends JpaRepository<PacienteEntidade, UUID> {

    @Query(nativeQuery = true, value = "SELECT EXISTS (SELECT 1 FROM tb_paciente WHERE cpf = :cpf)")
    Boolean verificaCpf(String cpf);
}
