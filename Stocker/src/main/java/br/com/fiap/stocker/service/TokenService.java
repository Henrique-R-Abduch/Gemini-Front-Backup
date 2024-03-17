package br.com.fiap.stocker.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
=======
import java.time.temporal.TemporalUnit;

>>>>>>> 477b2826d31c0d3d10f1d28c15240a7875e16294
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
<<<<<<< HEAD
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.fiap.stocker.model.Usuario;
import br.com.fiap.stocker.model.dto.Token;
import br.com.fiap.stocker.repository.UsuarioRepository;
=======

import br.com.fiap.stocker.model.dto.Token;
>>>>>>> 477b2826d31c0d3d10f1d28c15240a7875e16294



@Service
public class TokenService {
<<<<<<< HEAD

    @Autowired
    UsuarioRepository repository;
=======
>>>>>>> 477b2826d31c0d3d10f1d28c15240a7875e16294
    
    public Token generateToken(String email){
        Algorithm alg = Algorithm.HMAC512("meusecretsupersecreto");
        var jwt = JWT.create()
            .withIssuer("StockHelper")
            .withSubject(email)
            .withExpiresAt(Instant.now().plus(10, ChronoUnit.MINUTES))
            .sign(alg);

            return new Token(jwt, "JWT", "Bearer");
    }

<<<<<<< HEAD
    public Usuario validateToken(String token){
        Algorithm alg = Algorithm.HMAC512("meusecretsupersecreto"); 
        String email = JWT.require(alg)
            .withIssuer("StockHelper")
            .build()
            .verify(token)
            .getSubject()
            ;

            return repository
                .findByEmail(email)
                .orElseThrow(() -> new JWTVerificationException("Erro na verificação do Token"));
    }

=======
>>>>>>> 477b2826d31c0d3d10f1d28c15240a7875e16294
}
