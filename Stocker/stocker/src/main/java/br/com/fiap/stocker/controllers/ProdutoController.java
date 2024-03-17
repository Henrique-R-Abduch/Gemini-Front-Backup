package br.com.fiap.stocker.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.stocker.model.Produto;
import br.com.fiap.stocker.repository.ProdutoRepository;

import java.util.List;
import java.util.ArrayList;

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

@RestController
public class ProdutoController {

    Logger log = LoggerFactory.getLogger(getClass());
    List<Produto> Produtos = new ArrayList<>();

    @Autowired
    ProdutoRepository repository;

    @GetMapping("/produto")
    public List<Produto> ListAll() {
        return repository.findAll();
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> ListById(@PathVariable int id) {
        log.info("mostrar Produto com id " + id);
        return ResponseEntity.ok(getProdutoById(id));

    }

    @PostMapping("/produto")
    public ResponseEntity<Produto> Insert(@RequestBody Produto Produto) {
        log.info("cadastrando Produto - " + Produto);
        repository.save(Produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Produto);
    }

    @PutMapping("/produto/{id}")
    public ResponseEntity<Produto> update(@PathVariable int id, @RequestBody Produto Produto){
        log.info("atualizando dados do Produto com id " + id);
        getProdutoById(id);
        Produto.setId(id);
        repository.save(Produto);

        return ResponseEntity.ok(Produto);
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Object> DeleteById(@PathVariable int id){
        log.info("apagando Produto com id " + id);
        repository.delete(getProdutoById(id));
        return ResponseEntity.noContent().build();
    }


  private Produto getProdutoById(int id){
    return repository.findById(id).orElseThrow(() -> { 
         return new RuntimeException();
     });
    }



}