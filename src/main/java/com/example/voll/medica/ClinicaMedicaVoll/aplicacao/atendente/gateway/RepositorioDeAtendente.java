package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

import java.util.Optional;
import java.util.UUID;

public interface RepositorioDeAtendente {

    Atendente cadastrarAtendente(Atendente atendente);

    Optional<Atendente> filtrarAtendentePorUuid(UUID uuid);

    Atendente atualizarCadastroAtendente(UUID uuid, Atendente atendente);

    void deletarAtendentePorUuid(UUID uuid);

    Optional<Atendente> filtrarAtendentePorEmail(String email);

    Boolean validarEmail(String email);
}
