package com.example.voll.medica.ClinicaMedicaVoll.config;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.gateway.RepositorioDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.*;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.autentificador.AutenticadorDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.autentificador.AutenticarAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.criptografador.CriptografadorDeSenha;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.criptografador.CriptografarSenha;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.token.*;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.persistencia.RepositorioDeAtendenteJpa;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.persistencia.RepositorioDeAtendenteJpaAdapter;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.seguranca.FiltroDeSeguranca;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.seguranca.autenticador.AutenticadorDeAtendenteAdapter;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.seguranca.criptografador.CriptografadorDeSenhaAdapter;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.seguranca.token.GerenciadorDeTokenAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AtendenteConfig {

    @Bean
    CadastrarAtendente cadastrarAtendente(RepositorioDeAtendente repositorio, CriptografarSenha criptografarSenha) {
        return new CadastrarAtendente(repositorio, criptografarSenha);
    }

    @Bean
    FiltrarAtendentePorUuid filtrarAtendentePorUuid(RepositorioDeAtendente repositorio) {
        return new FiltrarAtendentePorUuid(repositorio);
    }

    @Bean
    FiltrarAtendentePorEmail filtrarAtendentePorEmail(RepositorioDeAtendente repositorio) {
        return new FiltrarAtendentePorEmail(repositorio);
    }

    @Bean
    AtualizarAtendente atualizarCadastroAtendente(RepositorioDeAtendente repositorio,
                                                  FiltrarAtendentePorUuid filtrarAtendentePorUuid,
                                                  CriptografarSenha criptografarSenha) {
        return new AtualizarAtendente(repositorio, filtrarAtendentePorUuid, criptografarSenha);
    }

    @Bean
    DeletarAtendente deletarAtendentePorUuid(RepositorioDeAtendente repositorio,
                                             FiltrarAtendentePorUuid filtrarAtendentePorUuid) {
        return new DeletarAtendente(repositorio, filtrarAtendentePorUuid);
    }

    @Bean
    RepositorioDeAtendenteJpaAdapter repositorioDeAtendente(RepositorioDeAtendenteJpa repositorio) {
        return new RepositorioDeAtendenteJpaAdapter(repositorio);
    }

    @Bean
    CriptografarSenha criptografarSenha(CriptografadorDeSenha criptografadorDeSenha) {
        return new CriptografarSenha(criptografadorDeSenha);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CriptografadorDeSenhaAdapter criptografadorDeSenhaAdapter(PasswordEncoder passwordEncoder) {
        return new CriptografadorDeSenhaAdapter(passwordEncoder);
    }

    @Bean
    GerarToken gerarToken(GerenciadorDeToken gerenciadorDeToken) {
        return new GerarToken(gerenciadorDeToken);
    }

    @Bean
    AutenticarToken autenticarToken(GerenciadorDeToken gerenciadorDeToken) {
        return new AutenticarToken(gerenciadorDeToken);
    }

    @Bean
    AtendenteToken atendenteToken(GerenciadorDeToken gerenciadorDeToken) {
        return new AtendenteToken(gerenciadorDeToken);
    }

    @Bean
    FuncaoToken fucaoToken(GerenciadorDeToken gerenciadorDeToken) {
        return new FuncaoToken(gerenciadorDeToken);
    }

    @Bean
    public GerenciadorDeToken gerenciadorDeToken() {
        return new GerenciadorDeTokenAdapter();
    }

    @Bean
    public AutenticadorDeAtendente autenticadorDeAtendente(
            AuthenticationManager authenticationManager) {
        return new AutenticadorDeAtendenteAdapter(authenticationManager);
    }

    @Bean
    public AutenticarAtendente autenticarAtendente(
            AutenticadorDeAtendente autenticadorDeAtendente) {
        return new AutenticarAtendente(autenticadorDeAtendente);
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    FiltroDeSeguranca filtroDeSeguranca(FiltrarAtendentePorEmail filtrarAtendentePorEmail,
                                        AtendenteToken atendenteToken, FuncaoToken funcaoToken) {
        return new FiltroDeSeguranca(filtrarAtendentePorEmail, atendenteToken, funcaoToken);
    }
}
