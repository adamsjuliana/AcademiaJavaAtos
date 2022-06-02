public class Pessoa {
	public String nomePessoa;
	public int idadePessoa;
	
	public Pessoa(String nome){
		nomePessoa = nome;
		System.out.println("Nome: " + nome);
	}
	public Pessoa(String nome, int idade) {
		nomePessoa = nome;
		idadePessoa = idade;
		System.out.println("Nome: " + nome + " | Idade:  " + idade);

	}
}
