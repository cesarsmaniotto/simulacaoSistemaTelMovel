package modelo.distribuicao;
public class Constante implements Distribuicao {

	private double valor;
	
	public Constante(double valor) {
		super();
		this.valor = valor;
	}

	@Override
	public double geraValor() {
		return valor;
	}


}