package br.com.fiap.stocker.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.stocker.model.TipoProduto;
import br.com.fiap.stocker.repository.TipoProdutoRepository;


@RestController
public class TipoProdutoController {
    
    Logger log = LoggerFactory.getLogger(getClass());
    List<TipoProduto> TipoProdutos = new ArrayList<>();

    @Autowired
    TipoProdutoRepository repository;

    @GetMapping("/tipoproduto")
    public List<TipoProduto> ListAll() {
        return repository.findAll();
    }

    @GetMapping("/tipoproduto/{id}")
    public ResponseEntity<TipoProduto> ListById(@PathVariable int id) {
        log.info("mostrar Tipo do Produto com id " + id);
        return ResponseEntity.ok(getTipoProdutoById(id));

    }

    @PostMapping("/tipoproduto")
    public ResponseEntity<TipoProduto> Insert(@RequestBody TipoProduto TipoProduto) {
        log.info("cadastrando Tipo do Produto - " + TipoProduto);
        repository.save(TipoProduto);
        return ResponseEntity.status(HttpStatus.CREATED).body(TipoProduto);
    }

    @PutMapping("/tipoproduto/{id}")
    public ResponseEntity<TipoProduto> update(@PathVariable int id, @RequestBody TipoProduto TipoProduto){
        log.info("atualizando dados do Tipo do Produto com id " + id);
        getTipoProdutoById(id);
        TipoProduto.setId(id);
        repository.save(TipoProduto);

        return ResponseEntity.ok(TipoProduto);
    }

    @DeleteMapping("/tipoproduto/{id}")
    public ResponseEntity<Object> DeleteById(@PathVariable int id){
        log.info("apagando Tipo do Produto com id " + id);
        repository.delete(getTipoProdutoById(id));
        return ResponseEntity.noContent().build();
    }


  private TipoProduto getTipoProdutoById(int id){
    return repository.findById(id).orElseThrow(() -> { 
         return new RuntimeException();
     });
    }
}
