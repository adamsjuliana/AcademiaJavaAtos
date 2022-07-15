package br.com.adams.Eletroposto.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import br.com.adams.Eletroposto.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired 
	private LoginSucesso loginSucesso;
	
	@Bean
	public BCryptPasswordEncoder gerarCriptografia() {
		BCryptPasswordEncoder criptografia = new BCryptPasswordEncoder();
		return criptografia;
	}
	
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		UsuarioService detalheDoUsuario = new UsuarioService(usuarioRepository);
		return detalheDoUsuario;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home", "/sobre", "/usuario/add", "/usuario/admin/**", "/agendar*").permitAll()
				.antMatchers("/css/**", "/images/**", "/js/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.exceptionHandling().accessDeniedPage("/acesso-negado")
				.and()
			.formLogin().successHandler(loginSucesso)
				.loginPage("/login")
				.defaultSuccessUrl("/", true)
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// O objeto que vai obter os detalhes do usuário
		UserDetailsService detalheDoUsuario = userDetailsServiceBean();
		// Objeto para criptografia
		BCryptPasswordEncoder criptografia = gerarCriptografia();
		
		auth.userDetailsService(detalheDoUsuario).passwordEncoder(criptografia);
	}

}