package br.com.fiap.stocker.model.dto;


public record Token(
    String token,
    String type,
    String prefix
    
 ) {}
