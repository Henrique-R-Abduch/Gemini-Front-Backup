package br.com.fiap.stocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.stocker.model.TipoProduto;

public interface TipoProdutoRepository extends JpaRepository<TipoProduto, Integer> {
    
    // @Query("SELECT c FROM categorias WHERE ....") //JPQL
    // List<Usuario> buscaOsDadosPeloMeuCriterioMaisMaluco(String nome);

}