package com.adams.exemploSprintJPARest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id = null;
	@Column(nullable=false, unique=true)
	private int codigo;
	@Column(nullable=false, length=50)
	private String nome;
	@Column(length=50)
	private String categoria;
	@Column(nullable=false)
	private Float valor;
	@Column(nullable=false)
	private int quantidade;

	public Produto(int codigo, String nome, String categoria, Float valor, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
		this.quantidade = quantidade;
	}	
	public Produto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public Long setId() {
		return id;
	}	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}