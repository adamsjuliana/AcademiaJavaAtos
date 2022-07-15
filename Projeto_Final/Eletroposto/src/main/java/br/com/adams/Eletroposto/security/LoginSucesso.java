package br.com.adams.Eletroposto.security;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import br.com.adams.Eletroposto.model.Papel;
import br.com.adams.Eletroposto.model.Usuario;
import br.com.adams.Eletroposto.repository.UsuarioRepository;


@Component
public class LoginSucesso extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {

		// pega o login do usuário logado
		String username = authentication.getName(); 
		// busca o usuário no banco pelo login
		Usuario usuario = usuarioRepository.findByUsername(username);	

        response.sendRedirect("/");         
    }
	/**
	 * Método que verifica qual papel o usuário tem na aplicação 
	 * */
	private boolean temAutorizacao(Usuario usuario, String papel) {
		for (Papel pp : usuario.getPapeis()) {
			if (pp.getPapel().equals(papel)) {
				return true;
			}
	    }
		return false;
	}
}
