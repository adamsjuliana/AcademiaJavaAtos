import java.util.Scanner;
/*
Construtores, Slide 56

Ex1: Criar uma classe chamada Pessoa com 2 construtores, um que receba o nome e a idade da pessoa
e outro recebendo apenas a idade. Solicite ao usu�rio qual dos construtores ele gostaria de utilizar
na instancia��o da classe. Al�m de receber par�metros, os construtores imprimem na tela o conte�do
dos par�metros recebidos.
 */
public class Principal {

	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
			System.out.println("Por favor, selecione uma op��o para adicionar: (1)Nome ou (2)Nome e idade");
			String tipo = leitura.nextLine();
			if(tipo.equals("1")) {
				System.out.println("Insira o Nome:");
				String nome1 = leitura.nextLine();
				Pessoa pessoa = new Pessoa(nome1);
			}
			else if(tipo.equals("2")) {
				System.out.println("Insira o Nome:");
				String nome1 = leitura.nextLine();
				System.out.println("Insira a idade:");
				int idade1 = Integer.valueOf(leitura.nextLine());
				Pessoa pessoa = new Pessoa(nome1, idade1);
			}
			else {
				System.out.println("Comando inv�lido!");
			}
}}
