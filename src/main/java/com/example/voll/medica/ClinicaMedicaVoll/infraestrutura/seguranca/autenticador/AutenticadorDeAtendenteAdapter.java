package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.seguranca.autenticador;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.autentificador.AutenticadorDeAtendente;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.entidade.AtendenteEntidade;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.mapper.AtendenteJpaMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AutenticadorDeAtendenteAdapter implements AutenticadorDeAtendente {

    private final AuthenticationManager authenticationManager;

    public AutenticadorDeAtendenteAdapter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Atendente autenticar(String email, String senha) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(email, senha);
        Authentication authentication = authenticationManager.authenticate(usernamePassword);
        return AtendenteJpaMapper.paraDominio((AtendenteEntidade) authentication.getPrincipal());
    }
}
