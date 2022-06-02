package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DAO {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	private String url = "jdbc:mysql://127.0.0.1:3306/projeto?useTimezone=true&serverTimezone=UTC";
	
	private String user = "root";
	
	private String password = "1234";
	
	//conctar
	private Connection conectar() {
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	public void inserirProduto(JavaBeans produto) {
		String create = "insert into produto (codigo, nome, categoria, valor, quantidade) values (?,?,?,?,?);";
		
		try {
			//abrindo a conexão
			Connection con = conectar();
			//epparara a query
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setString(4, produto.getValor());
			pst.setString(5, produto.getQuantidade());
			//excutar a query
			pst.executeUpdate();
			//Encerar conexão
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void editarProduto(JavaBeans produto) {
		String create = "update produto set codigo = ?, nome=? , categoria =?, valor = ?, quantidade = ? where id=?;";
		
		try {
			//abrindo a conexão
			Connection con = conectar();
			//epparara a query
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setString(4, produto.getValor());
			pst.setString(5, produto.getQuantidade());
			pst.setString(6, produto.getId());
			//excutar a query
			pst.executeUpdate();
			//Encerar conexão
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

//CRUD - READ recupera os valores contidos no Banco de dados - Tabela alunos
public ArrayList<JavaBeans> listarProdutos(){
	
	ArrayList<JavaBeans> produtos = new ArrayList();
	
	String read = "select * from produto order by nome;";
	
	try {
		//abrindo a conex�o
		Connection con = conectar();
		//epparara a query
		PreparedStatement pst = con.prepareStatement(read);
		//Executa a query e armazena na variavel rs
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			String id = rs.getString(1);
			String codigo = rs.getString(2);
			String nome = rs.getString(3);
			String categoria = rs.getString(4);
			String valor = rs.getString(5);
			String quantidade = rs.getString(6);
			//armazenar os valores no ArrayList
			produtos.add(new JavaBeans(id, codigo, nome, categoria, valor, quantidade));
		}
		con.close();
		return produtos;
		
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	
}
//CRUDE - DELETE - remove um registro do banco de dados
public void deletarProduto(JavaBeans produto) {
	String delete = "delete from produto where id = ?;";
	try {
		//abrindo a conex�o
		Connection con = conectar();
		//epparara a query
		PreparedStatement pst = con.prepareStatement(delete);
		pst.setString(1, produto.getId());
		pst.executeUpdate();
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
}

}
