package br.com.fiap.stocker.repository;

<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> 477b2826d31c0d3d10f1d28c15240a7875e16294
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.stocker.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
<<<<<<< HEAD

    Optional <Usuario> findByEmail(String email);
=======
    
    // @Query("SELECT c FROM categorias WHERE ....") //JPQL
    // List<Usuario> buscaOsDadosPeloMeuCriterioMaisMaluco(String nome);
>>>>>>> 477b2826d31c0d3d10f1d28c15240a7875e16294

}
