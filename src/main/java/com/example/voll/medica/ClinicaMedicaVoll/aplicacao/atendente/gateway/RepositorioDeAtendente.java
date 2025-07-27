package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

public interface RepositorioDeAtendente {

    Atendente cadastrarAtendente(Atendente atendente);

    Atendente filtrarAtendentePorLogin(String login);

    Atendente filtrarAtendentePorUuid(String uuid);

    Atendente atualizarCadastroAtendente(String uuid, Atendente atendente);

    void deletarAtendentePorUuid(String uuid);
}
