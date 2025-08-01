package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.consulta.entidade;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta.StatusConsulta;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConsultaEntidade {

    @Id
    private UUID uuid;

    private String crmMedico;
    private String cpfPaciente;
    private LocalDateTime dataEHora;
    private StatusConsulta status;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaEntidade that = (ConsultaEntidade) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }
}
