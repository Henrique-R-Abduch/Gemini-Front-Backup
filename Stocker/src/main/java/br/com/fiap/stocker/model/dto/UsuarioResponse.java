package br.com.fiap.stocker.model.dto;

import br.com.fiap.stocker.model.Usuario;

public record UsuarioResponse(
    Integer id,
    String nome,
    String email
) {

    public static UsuarioResponse fromUsuario(Usuario usuario) {
        return new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
    
}
