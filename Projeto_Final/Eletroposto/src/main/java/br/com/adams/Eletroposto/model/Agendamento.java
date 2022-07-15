package br.com.adams.Eletroposto.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Agendamento {
	@Id
	private String Data;
	private String usuario_id;

	public String getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public Agendamento(String data) {
		super();
		Data = data;
	}

	public Agendamento() {
		super();
}
}
