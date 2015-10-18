package modelo.distribuicao;

import java.util.Random;

public class Normal implements Distribuicao {

	private double media;
	private double desvioPadrao;
	private double proximo;
	private boolean proximoJaFoiCalculado;
	private Random random;

	public Normal(double media, double desvioPadrao) {
		super();
		this.media = media;
		this.desvioPadrao = desvioPadrao;
		this.random = new Random();
		this.proximoJaFoiCalculado = false;
		this.proximo = 0;
	}

	@Override
	public double geraValor() {

		if (proximoJaFoiCalculado) {
			proximoJaFoiCalculado = false;
			return proximo;
		} else {
			double aleatory1 = random.nextDouble();
			double aleatory2 = random.nextDouble();

			double z1 = Math.sqrt(-2 * Math.log(aleatory1))
					* Math.cos(2 * Math.PI * aleatory2);
			double z2 = Math.sqrt(-2 * Math.log(aleatory1))
					* Math.sin(2 * Math.PI * aleatory2);

			proximo = (media + (desvioPadrao * z2));
			proximoJaFoiCalculado = true;
			return (media + (desvioPadrao * z1));
		}

	}

}