package com.JpaAnnotation.BancoJava.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Long numeroConta;
	String nomeCompleto;
	Float saldoConta;

	@ManyToOne//cria um relacionamento muitos para um (conta x filial)
	Filial filial;

	public Conta(Long id, Long numeroConta, String nomeCompleto, Float saldoConta, Filial filial) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
		this.nomeCompleto = nomeCompleto;
		this.saldoConta = saldoConta;
		this.filial = filial;
	}
	public Conta() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Float getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(Float saldoConta) {
		this.saldoConta = saldoConta;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", numeroConta=" + numeroConta + ", nomeCompleto=" + nomeCompleto + ", saldoConta="
				+ saldoConta + ", filial=" + filial + "]";
	}

}
