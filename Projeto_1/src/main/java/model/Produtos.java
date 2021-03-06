package model;

public class Produtos {
	private String id;
	private String codigo;
	private String nome;
	private String categoria;
	private String valor;
	private String quantidade;

	public Produtos(String id, String codigo, String nome, String categoria, String valor, String quantidade) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.categoria = categoria;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public Produtos() {
		super();
	}
	
	public String getId() {
		return id;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	public String getCategoria() {
		return categoria;
	}	
	
	public String getValor() {
		return valor;
	}	
	
	public String getQuantidade() {
		return quantidade;
	}	
	
	public void setId(String id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
}