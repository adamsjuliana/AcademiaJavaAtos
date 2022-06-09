import java.util.Scanner;
/*
 Classes, Atributos e Métodos, Slide 33

Ex4: Crie uma classe chamada Moto com três atributos (marca, modelo e cilindradas) e
dois métodos (atribuir valores e retornar valores). Na classe LocadoraVeiculos, crie um
objeto do tipo Carro e dois objetos do tipo Moto, sendo que os objetos serão criados de
acordo com a solicitação desses dados ao usuário, via linha de execução, conforme exemplo
abaixo (vide material fornecido). Após a criação dos objetos, utilize o método para
retornar valores e exiba na tela o conteúdo dos objetos criados.
 */

public class LocadoraVeiculos {

	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		String resp = "s";
		while (resp.equals("s")) {
			System.out.println("Informe seu veiculo: (m) para moto e (c) carro: ");
			String tipo = leitura.nextLine();
			if (tipo.equals("m")) {
				Moto moto = new Moto();
				System.out.println("Insira o Fabricante:");
				String Fabricante = leitura.nextLine();
				System.out.println("Insira o Modelo:");
				String Modelo = leitura.nextLine();
				System.out.println("Insira as Cilindradas:");
				String Cilindradas = leitura.nextLine();
				moto.dados(Fabricante, Modelo, Cilindradas);
				System.out.println(moto);
				System.out.println("Gostaria de cadastrar outro veículo? s/n");
				resp = leitura.nextLine();
			}
			else if (tipo.equals("c")) {
				Carro carro = new Carro();
				System.out.println("Insira o Fabricante:");
				String Fabricante = leitura.nextLine();
				System.out.println("Insira o Modelo:");
				String Modelo = leitura.nextLine();
				carro.dados(Fabricante, Modelo);
				System.out.println(carro);
				System.out.println("Gostaria de cadastrar outro veículo? s/n");
				resp = leitura.nextLine();
			} else {
				System.out.println("Comando inválido!");
			}
		}
	}

}