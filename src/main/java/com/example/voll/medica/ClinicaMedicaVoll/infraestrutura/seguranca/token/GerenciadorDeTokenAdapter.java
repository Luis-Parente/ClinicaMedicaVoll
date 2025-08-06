package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.seguranca.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.excecao.TokenExcecao;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.token.GerenciadorDeToken;
import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.Atendente;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class GerenciadorDeTokenAdapter implements GerenciadorDeToken {

    @Value("${api.security.token.secret}")
    private String segredo;

    @Override
    public String gerarToken(Atendente atendente) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(segredo);
            return JWT.create()
                    .withIssuer("token-generator")
                    .withSubject(atendente.getEmail())
                    .withClaim("role", atendente.getNivelDeAcesso().name())
                    .withExpiresAt(LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new TokenExcecao("Erro gerando token de acesso!");
        }
    }

    @Override
    public String autenticarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(segredo);
            return JWT.require(algorithm).withIssuer("token-generator").build().verify(token).getSubject();
        } catch (JWTVerificationException e) {
            throw new TokenExcecao("Erro validando token de acesso!");
        }
    }

    @Override
    public String atendenteToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(segredo);
            return JWT.require(algorithm).withIssuer("token-generator").build().verify(token).getSubject();
        } catch (JWTVerificationException e) {
            throw new TokenExcecao("Token inválido!");
        }
    }

    @Override
    public String funcaoToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(segredo);
            return JWT.require(algorithm).withIssuer("token-generator").build().verify(token).getClaim("role")
                    .asString();
        } catch (JWTVerificationException e) {
            throw new TokenExcecao("Token inválido!");
        }
    }
}
