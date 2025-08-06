package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.seguranca;

import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.atendente.usecases.FiltrarAtendentePorEmail;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.token.AtendenteToken;
import com.example.voll.medica.ClinicaMedicaVoll.aplicacao.seguranca.token.FuncaoToken;
import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.mapper.AtendenteJpaMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class FiltroDeSeguranca extends OncePerRequestFilter {

    private final FiltrarAtendentePorEmail filtrarAtendentePorEmail;

    private final AtendenteToken atendenteToken;

    private final FuncaoToken funcaoToken;

    public FiltroDeSeguranca(FiltrarAtendentePorEmail filtrarAtendentePorEmail, AtendenteToken atendenteToken,
                             FuncaoToken funcaoToken) {
        this.filtrarAtendentePorEmail = filtrarAtendentePorEmail;
        this.atendenteToken = atendenteToken;
        this.funcaoToken = funcaoToken;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        var token = recoverToken(request);
        if (token != null) {
            String email = atendenteToken.atendenteDoToken(token);

            String funcao = funcaoToken.funcaoDoToken(token);

            UserDetails user = AtendenteJpaMapper.paraEntidade(filtrarAtendentePorEmail.findByEmail(email));

            var authorities = List.of(new SimpleGrantedAuthority("ROLE_" + funcao));

            var authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
