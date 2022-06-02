import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) throws SQLException {
		// Cria��o da Classe BancoDados
		BancoDados bd = new BancoDados();	
		// Endere�o para conex�o ao BD
		String urlBD = "jdbc:mysql://localhost:3306/BIBLIOTECA?user=root&password=1234";	
		// Driver utilizado para acesso ao BD
		String driver = "com.mysql.cj.jdbc.Driver";
		//ResultSet "Tabela" com os valores retornados da Busca
		ResultSet resultado = null;
		
		// Conex�o ao BD
		System.out.println(bd.conectar(urlBD, driver));
		resultado = bd.consultar("SELECT Livro.ISBN, Livro.titulo, Livro.ano, Editora.nome, Autor.nome, Autor.nacionalidade, Categoria.tipo_categoria\r\n"
				+ "FROM Livro_Autor, Livro, Categoria, Editora, Autor\r\n"
				+ "WHERE Livro_Autor.fk_livro = Livro.ISBN\r\n"
				+ "AND Livro.id_categoria = Categoria.id\r\n"
				+ "AND Livro.id_editora = Editora.id\r\n"
				+ "AND Livro_Autor.fk_autor = Autor.id\r\n"
				+ "ORDER BY Livro.titulo;");

		// Verifica se o resultado retornada da pesquisa junto ao BD n�o � vazio, sen�o for exibe no console
		if (resultado != null)
			while (resultado.next()) {
				System.out.println("ISBN: " + resultado.getString("Livro.ISBN") + "\t T�tulo: " + resultado.getString("Livro.titulo")
								+ "\t Ano: " + resultado.getString("Livro.ano") + "\t Editora: " + resultado.getString("Editora.nome")
								+ "\t Autor/Nacionalidade: " + resultado.getString("Autor.nome") + "/" + resultado.getString("Autor.nacionalidade") + "\t Categoria: " + resultado.getString("Categoria.tipo_categoria"));
			}
		// Verifica se o resultado retornada da pesquisa junto ao BD n�o � vazio, sen�o for exibe no console
		if (resultado != null)
			while (resultado.next()) {
				System.out.println("ISBN: " + resultado.getString("Autor.nome") + "\t T�tulo: " + resultado.getString("Autor.nacionalidade"));}
		
//Mostrando resultado da pesquisa

		//Adicionando Livro e Livro_autor   *~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*
		
//Mostrando resultado da pesquisa ap�s inser��o do Livro
	}

}