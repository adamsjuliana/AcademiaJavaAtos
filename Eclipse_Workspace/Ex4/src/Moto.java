

public class Moto extends Veiculo {

	// public String Fabricante;
	// public String Modelo;
	public String Cilindradas;

	public void dados(String fabricanteMoto, String modeloMoto, String cilindradasMoto) {
		Fabricante = fabricanteMoto;
		Modelo = modeloMoto;
		Cilindradas = cilindradasMoto;
	}

	public String getCil() {
		// System.out.println(Cilindradas);
		return Cilindradas;
	}

	public void exibirDados() {
		System.out.println("Fabricante: " + getFab() + " | Modelo : " + getMod() + " | Cilindradas: " + getCil());
	}

	@Override
	public String toString() {
		return "Moto | Fabricante : " + Fabricante + " | Modelo: " + Modelo + " | Cilindradas: " + Cilindradas;
	}

}
