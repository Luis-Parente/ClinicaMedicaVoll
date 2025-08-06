package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.seguranca.criptografador;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.criptografador.CriptografadorDeSenha;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CriptografadorDeSenhaAdapter implements CriptografadorDeSenha {

    private final PasswordEncoder passwordEncoder;

    public CriptografadorDeSenhaAdapter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String criptografarSenha(String senha) {
        return passwordEncoder.encode(senha);
    }
}
