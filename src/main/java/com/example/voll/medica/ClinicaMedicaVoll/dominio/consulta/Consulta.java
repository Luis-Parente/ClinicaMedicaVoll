package com.example.voll.medica.ClinicaMedicaVoll.dominio.consulta;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Consulta {

    private UUID uuid;

    private String crmMedico;
    private String cpfPaciente;
    private LocalDateTime dataEHora;
    private StatusConsulta status;

    public Consulta(UUID uuid, String crmMedico, String cpfPaciente, LocalDateTime dataEHora, StatusConsulta status) {

        if (crmMedico == null || !crmMedico.matches("^\\d{4,8}-[A-Z]{2}$")) {
            throw new IllegalArgumentException("CRM no formato incorreto!");
        }

        if (cpfPaciente == null || !cpfPaciente.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF no formato incorreto!");
        }

        this.uuid = uuid != null ? uuid : UUID.randomUUID();
        this.crmMedico = crmMedico;
        this.cpfPaciente = cpfPaciente;
        this.dataEHora = dataEHora;
        this.status = status != null ? status : StatusConsulta.AGENDADO;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public LocalDateTime getDataEHora() {
        return dataEHora;
    }

    public void setDataEHora(LocalDateTime dataEHora) {
        if (LocalDateTime.now().isAfter(dataEHora)) {
            throw new IllegalArgumentException("A consulta deve ser agendada numa data futura!");
        }
        this.dataEHora = dataEHora;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(uuid, consulta.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "uuid=" + uuid +
                ", crmMedico='" + crmMedico + '\'' +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                ", dataEHora=" + dataEHora +
                ", status=" + status +
                '}';
    }
}
