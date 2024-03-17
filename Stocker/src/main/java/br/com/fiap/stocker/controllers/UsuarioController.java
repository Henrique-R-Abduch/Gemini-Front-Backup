package br.com.fiap.stocker.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.stocker.model.Usuario;
import br.com.fiap.stocker.model.dto.Credenciais;
import br.com.fiap.stocker.model.dto.Token;
import br.com.fiap.stocker.model.dto.UsuarioResponse;
import br.com.fiap.stocker.repository.UsuarioRepository;
import br.com.fiap.stocker.service.TokenService;
import lombok.extern.log4j.Log4j2;


@RestController
@Log4j2
public class UsuarioController {
    
    Logger log = LoggerFactory.getLogger(getClass());
    List<Usuario> usuarios = new ArrayList<>();

    @Autowired
    UsuarioRepository repository;
    @Autowired
    TokenService service;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/usuario")
    public List<Usuario> ListAll() {
        return repository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> ListById(@PathVariable int id) {
        log.info("mostrar usuario com id " + id);
        return ResponseEntity.ok(getUsuarioById(id));

    }
  

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioResponse> Insert(@RequestBody Usuario usuario) {
        log.info("cadastrando usuario - " + usuario);
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(UsuarioResponse.fromUsuario(usuario));
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Usuario> update(@PathVariable int id, @RequestBody Usuario usuario){
        log.info("atualizando dados da usuario com id " + id);
        getUsuarioById(id);
        usuario.setId(id);
        repository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Object> DeleteById(@PathVariable int id){
        log.info("apagando usuario com id " + id);
        repository.delete(getUsuarioById(id));
        return ResponseEntity.noContent().build();
    }


  private Usuario getUsuarioById(int id){
    return repository.findById(id).orElseThrow(() -> { 
         return new RuntimeException();
     });
    }


    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody Credenciais credenciais){
        authManager.authenticate(credenciais.ToAuthentication());
        return ResponseEntity.ok(service.generateToken("henriqueabduch@gmail.com"));
    }

}
