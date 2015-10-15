package modelo.distribuicao;

import java.util.Random;


public class Exponencial implements Distribuicao {

	private double media;
	private Random random;
	
	public Exponencial(double media) {
		this.media = media;
		this.random = new Random();
	}
	
	
	@Override
	public double geraValor() {
		
		return (float) (- media * Math.log(1 - random.nextDouble()));
		
	}


}