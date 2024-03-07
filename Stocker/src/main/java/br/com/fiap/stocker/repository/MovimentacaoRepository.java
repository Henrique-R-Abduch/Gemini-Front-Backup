package br.com.fiap.stocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.stocker.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository <Movimentacao, Integer>{
    
}
