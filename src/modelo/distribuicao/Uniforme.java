package modelo.distribuicao;

import java.util.Random;

public class Uniforme implements Distribuicao {
	
	private Random random = new Random();
	private double minimo;
	private double maximo;

	public Uniforme(double minimo, double maximo) {
		super();
		this.minimo = minimo;
		this.maximo = maximo;
	}

	public double geraValor() {

		double aleatory = random.nextDouble();

		return minimo + ((maximo - minimo) * aleatory);
	}

}