package com.example.voll.medica.ClinicaMedicaVoll.infraestrutura.atendente.entidade;

import com.example.voll.medica.ClinicaMedicaVoll.dominio.atendente.NivelDeAcesso;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_atendente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AtendenteEntidade implements UserDetails {

    @Id
    private UUID uuid;

    private String nome;

    @Column(unique = true)
    private String email;
    private String senha;

    private NivelDeAcesso nivelDeAcesso;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AtendenteEntidade that = (AtendenteEntidade) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.nivelDeAcesso == NivelDeAcesso.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
