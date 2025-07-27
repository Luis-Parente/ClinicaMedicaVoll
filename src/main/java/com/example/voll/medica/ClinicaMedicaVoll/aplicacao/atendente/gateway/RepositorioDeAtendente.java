package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

import java.util.UUID;

public interface RepositorioDeAtendente {

    Atendente cadastrarAtendente(Atendente atendente);

    Atendente buscarAtendentePorLogin(String login);

    Atendente atualizarCadastroAtendente(Atendente atendente);

    void deletarAtendentePorUuid(String uuid);
}
