package com.universidadejava.UJava.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	// Cria uma nova tabela "cursos_alunos", gerando um relacionamento muitos para
	// muitos
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) // https://www.devmedia.com.br/lazy-e-eager-loading-com-hibernate/29554
	@JoinTable(name = "cursos_alunos", joinColumns = {
			@JoinColumn(name = "aluno_id", referencedColumnName = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "curso_id", referencedColumnName = "id", nullable = false, updatable = false) })
	private Set<Curso> cursos = new HashSet<>();// Set que armazena os cursos no qual o aluno esta inscrito

	public Set<Curso> getCursos() {
		return cursos;
	}

	public Aluno() {

	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + "]";
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Aluno(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Aluno(Long id, String nome, Set<Curso> cursos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cursos = cursos;
	}

}
