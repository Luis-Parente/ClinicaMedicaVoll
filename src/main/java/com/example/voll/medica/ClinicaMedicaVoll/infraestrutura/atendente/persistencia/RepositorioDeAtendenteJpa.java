package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.persistencia;

import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.entidade.AtendenteEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositorioDeAtendenteJpa extends JpaRepository<AtendenteEntidade, UUID> {
}
