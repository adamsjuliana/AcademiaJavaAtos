package com.adams.ProjetoJ.Security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.adams.ProjetoJ.Models.Usuario;
import com.adams.ProjetoJ.Repositories.UsuarioRepository;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Bean //Bean que é responsável pela liberação de acesso ou não a uma determinada view.
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/usuario/add", "/sobre").permitAll()
		//.antMatchers("/jusers/up", "/jusers/add").hasAuthority("ROLE_ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/", true)
			.permitAll() //Configura o acesso a view de login e da acesso irrestrito a ela
			.and()
		.logout()
			.permitAll();
		return http.build();
	}
	@Bean //Bean que cria um usuário em memória para acessar a aplicação via autenticação
	public InMemoryUserDetailsManager userDetailsService() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		Usuario usuarioTemp;
		List<UserDetails> userDetailsList = new ArrayList<>();
		for (int i=0; i<usuarios.size(); i++) {
			usuarioTemp = usuarios.get(i);
			System.out.println(usuarioTemp.getEmail());
			//withDetaultPasswordEncoder não criptografa a senha. Só utilizado para fins de estudo.
			userDetailsList.add(User
					.withDefaultPasswordEncoder()
					.username(usuarioTemp.getEmail().toString())
					.password(usuarioTemp.getSenha().toString())
					.roles(usuarioTemp.getRole().toString()).build());
		}
		return new InMemoryUserDetailsManager(userDetailsList);
	}
}
