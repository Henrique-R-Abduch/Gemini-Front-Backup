package br.com.fiap.stocker.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_USUARIO", uniqueConstraints = {
    @UniqueConstraint(name = "UK_NM_USUARIO", columnNames = {"NM_USUARIO"})
})
public class Usuario implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_USUARIO")
    @SequenceGenerator(name = "ID_USUARIO", sequenceName = "ID_USUARIO")
    @Column(name = "ID_USUARIO")
    private int id;

    @NotBlank
    @Column(name = "NM_USUARIO", nullable = false)
    private String nome;

    @Size(min = 8)
    @Column(name = "SENHA_USUARIO")
    private String senha;

    @Email @NotBlank
    @Column(name = "EMAIL_USUARIO")
    private String email;

    @Column(name = "PERM_USUARIO")
    private String permissao;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("Role_user"));    }

    @Override
    public String getPassword() {
        return senha;    }

    @Override
    public String getUsername() {
        return email;    }

    @Override
    public boolean isAccountNonExpired() {
        return true;    }

    @Override
    public boolean isAccountNonLocked() {
        return true;    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Authentication ToAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, null, getAuthorities());
    }

}
