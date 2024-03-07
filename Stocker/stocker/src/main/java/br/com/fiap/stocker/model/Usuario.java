package br.com.fiap.stocker.model;

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
import jakarta.validation.constraints.Past;
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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_USUARIO")
    @SequenceGenerator(name = "ID_USUARIO", sequenceName = "ID_USUARIO")
    @Column(name = "ID_USUARIO")     
    private int id;

    @NotBlank
    @Column(name = "NM_USUARIO", nullable = false)
    private String nome;

    @Past
    @Column(name = "SENHA_USUARIO")
    private String senha;

    @Email
    @Column(name = "EMAIL_USUARIO")
    private String email;

    @Column(name = "PERM_USUARIO")
    private String permissao;

}
