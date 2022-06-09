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

	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void inserirProduto(JavaBeans produto) {
		String create = "insert into produto (codigo, nome, categoria, valor, quantidade) values (?,?,?,?,?);";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setString(4, produto.getValor());
			pst.setString(5, produto.getQuantidade());
			// excutar a query
			pst.executeUpdate();
			// Encerar conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarProduto(JavaBeans produto) {
		String update = "update produto set codigo = ?, nome = ?, categoria = ?, valor = ?, quantidade = ? where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getCategoria());
			pst.setString(4, produto.getValor());
			pst.setString(5, produto.getQuantidade());
			pst.setString(6, produto.getId());
			pst.executeUpdate();
			// Encerrar a conex�o
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void selecionarProduto(JavaBeans produto) {
		String read2 = "select * from produto where id = ?;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, produto.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// setar as variavies JavaBeans
				produto.setId(rs.getString(1));
				produto.setCodigo(rs.getString(2));
				produto.setNome(rs.getString(3));
				produto.setCategoria(rs.getString(4));
				produto.setValor(rs.getString(5));
				produto.setQuantidade(rs.getString(6));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}}
	
	public void deletarProduto(JavaBeans produto) {
		String delete = "delete from produto where id = ?;";
		try {
			//Abre conexão
			Connection con = conectar();
			//Prepara a query
			PreparedStatement pst = con.prepareStatement(delete);
			//Recebe o ID
			pst.setString(1, produto.getId());
			//Deleta o produto
			pst.executeUpdate();
			//Encerra a conexão
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<JavaBeans> listarProdutos() {
		ArrayList<JavaBeans> produtos = new ArrayList<JavaBeans>();
		String read = "select * from produto order by categoria;";

		try {
			//Abre conexão
			Connection con = conectar();
			//Prepara a query
			PreparedStatement pst = con.prepareStatement(read);
			//Executa a query
			ResultSet rs = pst.executeQuery();
			//Armazena na variável rs
			while (rs.next()) {
				String id = rs.getString(1);
				String codigo = rs.getString(2);
				String nome = rs.getString(3);
				String categoria = rs.getString(4);
				String valor = rs.getString(5);
				String quantidade = rs.getString(6);
				// armazenar os valores no ArrayList
				produtos.add(new JavaBeans(id, codigo, nome, categoria, valor, quantidade));
			}
			//Encerra a conexão
			con.close();
			return produtos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
