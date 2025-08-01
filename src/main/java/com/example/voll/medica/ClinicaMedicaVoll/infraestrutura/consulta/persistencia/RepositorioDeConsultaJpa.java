package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.consulta.persistencia;

import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.consulta.entidade.ConsultaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RepositorioDeConsultaJpa extends JpaRepository<ConsultaEntidade, UUID> {

    @Query(nativeQuery = true, value = "SELECT EXISTS (SELECT 1 FROM tb_consulta WHERE dataehora = :dataEHora AND status = 0)")
    Boolean verificaData(LocalDateTime dataEHora);

    List<ConsultaEntidade> findAllByCpfPaciente(String cpfPaciente);

    @Query(nativeQuery = true, value = "SELECT * FROM tb_consulta WHERE crm_medico = :crmMedico AND (dataehora BETWEEN :dataInicial AND :dataFinal)")
    List<ConsultaEntidade> findAllByCrmAndDate(String crmMedico, LocalDate dataInicial, LocalDate dataFinal);
}
