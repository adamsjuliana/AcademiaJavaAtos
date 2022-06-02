

public class Carro extends Veiculo {

	public void dados(String fabricanteCarro, String modeloCarro) {
		Fabricante = fabricanteCarro;
		Modelo = modeloCarro;
	}

	public void exibirDados() {
		System.out.println("Fabricante: " + getFab() + " | Modelo : " + getMod());
	}

	@Override
	public String toString() {
		return "Carro" + " | Fabricante : " + Fabricante + " | Modelo: " + Modelo;
	}

}
