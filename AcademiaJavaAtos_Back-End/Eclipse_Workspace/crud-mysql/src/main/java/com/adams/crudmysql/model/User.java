package com.adams.crudmysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Hibernate criar uma tabela de classe
public class User {
	@Id //Identificador do BD
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false, length=50)
	private String name;
	@Column(nullable=false)
	private String email;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	public void setName(String name) {
		this.name = name;
	}	
	public void setEmail(String email) {
		this.email = email;
	}
}
