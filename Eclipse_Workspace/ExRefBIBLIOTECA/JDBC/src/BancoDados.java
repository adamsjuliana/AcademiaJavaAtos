import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoDados {
	public Connection conexao;

	String urlBD = "jdbc:mysql://localhost:3306/BIBLIOTECA?user=root&password=1234";
	
	String driver = "com.mysql.cj.jdbc.Driver";
	
	public String conectar(String URL, String Driver) {
		try {
			Class.forName(Driver);
			conexao = (Connection) DriverManager.getConnection(URL);
			return "Conectado";
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return "Não foi Possível Conectar ";
		}

	}

	public ResultSet consultar(String query) {
		Statement st;
		ResultSet resultado = null;
		try {
			st = conexao.createStatement();
			resultado = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;

	}

	public int inserirAlterarExcluir(String query) {
		int linhas = 0;
		try {
			Statement st = conexao.createStatement();
			linhas = st.executeUpdate(query);
			System.out.println("Operação Efetudada com Sucesso");
			return linhas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Operação Não Efetuada");
		}
		return linhas;

	}
	
	}