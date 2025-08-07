package com.example.voll.medica.ClinicaMedicaVoll.config;

import com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.seguranca.FiltroDeSeguranca;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SegurancaConfig {

    private final FiltroDeSeguranca filtroDeSeguranca;

    public SegurancaConfig(FiltroDeSeguranca filtroDeSeguranca) {
        this.filtroDeSeguranca = filtroDeSeguranca;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable());
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.authorizeHttpRequests(auth -> {
            auth.requestMatchers(HttpMethod.POST, "/atendente/login").permitAll();
            auth.requestMatchers(HttpMethod.POST, "/atendente").hasRole("ADMIN");
            auth.requestMatchers("/swagger-ui/**").permitAll();
            auth.requestMatchers("/v3/**").permitAll();
            auth.anyRequest().authenticated();
        });
        httpSecurity.addFilterBefore(filtroDeSeguranca, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
