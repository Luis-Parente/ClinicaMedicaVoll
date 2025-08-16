package com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.CampoInvalidoExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.criptografador.CriptografarSenha;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;

public class CadastrarAtendente {

    private final RepositorioDeAtendente repositorio;

    private final CriptografarSenha criptografarSenha;

    public CadastrarAtendente(RepositorioDeAtendente repositorio, CriptografarSenha criptografarSenha) {
        this.repositorio = repositorio;
        this.criptografarSenha = criptografarSenha;
    }

    public Atendente cadastrarNovoAtendente(Atendente atendente) {
        if (repositorio.validarEmail(atendente.getEmail()))
            throw new CampoInvalidoExcecao("E-mail já utilizado");
        atendente.setSenha(criptografarSenha.criptografarSenha(atendente.getSenha()));
        return repositorio.salvarAtendente(atendente);
    }
}
