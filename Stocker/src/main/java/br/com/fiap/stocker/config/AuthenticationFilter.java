package br.com.fiap.stocker.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.fiap.stocker.model.Usuario;
import br.com.fiap.stocker.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter extends OncePerRequestFilter{

    @Autowired
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                
                var token = getToken(request);

                if(token != null){
                    Usuario user = tokenService.validateToken(token);
                    Authentication auth = user.ToAuthentication();
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }

                filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        var header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer")) return null;

        var token = header.replace("Bearer", "");

        return header;
    }
    


}
