package br.com.fiap.stocker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.stocker.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional <Usuario> findByEmail(String email);

}
