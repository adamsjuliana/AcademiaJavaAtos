import java.sql.SQLException;
import java.util.Scanner;

public class Inserir {

	public static void main(String[] args) throws SQLException {
		// Criação da Classe BancoDados
		BancoDados bd = new BancoDados();

		// Endereço para conexão ao BD
		String urlBD = "jdbc:mysql://localhost:3306/BIBLIOTECA?user=root&password=1234";

		// Driver utilizado para acesso ao BD
		String driver = "com.mysql.cj.jdbc.Driver";

		// Conexão ao BD
		System.out.println(bd.conectar(urlBD, driver));

		// Inserindo dados no Banco de dados:

		Scanner leitura = new Scanner(System.in);
		String resp = "s";
		while (resp.equals("s")) {
			System.out.println("Você gostaria de adicionar um Livro, Autor, Editora, Categoria ou Autor_Livro?");
			String Resposta = leitura.nextLine();
			if (Resposta.equals("Livro")) {
				System.out.println("Insira o ISBN: ");
				String isbn = leitura.nextLine();
				System.out.println("Insira o título: ");
				String titulo = leitura.nextLine();
				System.out.println("Insira o ano: ");
				String ano = leitura.nextLine();
				System.out.println("Insira o id da categoria: ");
				String id_categoria = leitura.nextLine();
				System.out.println("Insira o id da editora: ");
				String id_editora = leitura.nextLine();
				System.out.println(bd.inserirAlterarExcluir("INSERT INTO Livro (isbn, titulo, ano, id_categoria, id_editora) values ('" + isbn + "', '" + titulo + "', '" + ano + "', '" + id_categoria + "', '" + id_editora + "');"));
			}else if (Resposta.equals("Autor")) {
				System.out.println("Insira o nome: ");
				String nome = leitura.nextLine();
				System.out.println("Insira o nacionalidade: ");
				String nacionalidade = leitura.nextLine();
				System.out.println(bd.inserirAlterarExcluir("INSERT INTO Autor (nome, nacionalidade) values ('" + nome + "', '" + nacionalidade + "');"));
			}else if (Resposta.equals("Categoria")) {
				System.out.println("Insira o nome: ");
				String nome = leitura.nextLine();
				System.out.println(bd.inserirAlterarExcluir("INSERT INTO Categoria (tipo_categoria) values ('" + nome + "');"));
			}else if (Resposta.equals("Editora")) {
				System.out.println("Insira o nome: ");
				String nome = leitura.nextLine();
				System.out.println(bd.inserirAlterarExcluir("INSERT INTO Editora (nome) values ('" + nome + "');"));
			}else if (Resposta.equals("Autor_Livro")) {
				System.out.println("Insira o id do Autor: ");
				String id_autor = leitura.nextLine();
				System.out.println("Insira o ISBN do Livro: ");
				String isbn = leitura.nextLine();
				System.out.println(bd.inserirAlterarExcluir("INSERT INTO Livro_Autor (fk_autor, fk_livro) values ('" + id_autor + "','" + isbn + "');"));
			}else {
					System.out.println("Comando inválido!");
			}
		}
	} 

}