package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

import java.util.Optional;

public interface RepositorioDeAtendente {

    Atendente cadastrarAtendente(Atendente atendente);

    Optional<Atendente> filtrarAtendentePorUuid(String uuid);

    Atendente atualizarCadastroAtendente(String uuid, Atendente atendente);

    void deletarAtendentePorUuid(String uuid);
}
