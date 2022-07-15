package br.com.adams.Eletroposto.security;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.adams.Eletroposto.model.Papel;
import br.com.adams.Eletroposto.model.Usuario;
import br.com.adams.Eletroposto.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService implements UserDetailsService {
	

	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		if(usuario != null && usuario.isAtivo()) {
			Set<GrantedAuthority> papeisDoUsuario = new HashSet<GrantedAuthority>();
			for(Papel papel: usuario.getPapeis()) {
				GrantedAuthority pp = new SimpleGrantedAuthority(papel.getPapel());
				papeisDoUsuario.add(pp);
			}			
			User user = new User(usuario.getUsername(), usuario.getPassword(), papeisDoUsuario);
			return user;
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
	}

}
