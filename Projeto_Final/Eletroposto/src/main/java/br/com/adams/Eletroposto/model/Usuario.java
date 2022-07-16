package br.com.adams.Eletroposto.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="Campo obrigatório.")
	private String nome;
	@NotEmpty(message="Campo obrigatório.")
	@Email(message ="E-mail inválido.")
	private String email;
	@NotEmpty(message="Campo obrigatório.")
	@Size(min = 5, message ="O username precisa ter no mínimo 5 caracteres.")
	private String username;
	@NotEmpty(message="Campo obrigatório.")
	private String password;
	
	private boolean ativo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="usuario_papel", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name ="papel_id"))
	private List<Papel> papeis;

	public List<Papel> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<Papel> papeis) {
		this.papeis = papeis;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Usuario() {
		super();
	}

	
	
}