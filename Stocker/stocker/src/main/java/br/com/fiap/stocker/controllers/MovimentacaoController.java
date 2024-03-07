package br.com.fiap.stocker.controllers;

import java.util.ArrayList;
import java.util.List;

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

import br.com.fiap.stocker.model.Movimentacao;
import br.com.fiap.stocker.repository.MovimentacaoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MovimentacaoController {
    
    List<Movimentacao> Movimentacoes = new ArrayList<>();

    @Autowired
    MovimentacaoRepository repository;

    @GetMapping("/movimentacao")
    public List<Movimentacao> ListAll() {
        log.info("buscando todas movimentações =D!");
        return repository.findAll();
    }

     @GetMapping("/movimentacao/{id}")
    public ResponseEntity<Movimentacao> ListById(@PathVariable int id) {
        log.info("mostrar Movimentacao com id " + id);
        return ResponseEntity.ok(getMovimentacaoById(id));

    }

    @PostMapping("/movimentacao")
    public ResponseEntity<Object> Insert(@RequestBody @Valid Movimentacao Movimentacao) {
        log.info("cadastrando Movimentacao - " + Movimentacao);
        repository.save(Movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(Movimentacao);
    }

    @PutMapping("/movimentacao/{id}")
    public ResponseEntity<Movimentacao> update(@PathVariable int id, @RequestBody Movimentacao Movimentacao){
        log.info("atualizando dados do Movimentacao com id " + id);
        getMovimentacaoById(id);
        Movimentacao.setId(id);
        repository.save(Movimentacao);

        return ResponseEntity.ok(Movimentacao);
    }

    @DeleteMapping("/movimentacao/{id}")
    public ResponseEntity<Object> DeleteById(@PathVariable int id){
        log.info("apagando Movimentacao com id " + id);
        repository.delete(getMovimentacaoById(id));
        return ResponseEntity.noContent().build();
    }

    private Movimentacao getMovimentacaoById(int id){
        return repository.findById(id).orElseThrow(() -> { 
             return new RuntimeException();
         });
        }
    

}
