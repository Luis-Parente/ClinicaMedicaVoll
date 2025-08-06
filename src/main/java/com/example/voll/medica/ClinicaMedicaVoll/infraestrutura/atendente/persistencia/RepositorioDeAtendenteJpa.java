package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.persistencia;

import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.entidade.AtendenteEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface RepositorioDeAtendenteJpa extends JpaRepository<AtendenteEntidade, UUID> {

    Optional<AtendenteEntidade> findByEmail(String email);

    @Query(nativeQuery = true, value = "SELECT EXISTS (SELECT 1 FROM tb_atendente WHERE email = :email)")
    Boolean verificaEmail(String email);
}
