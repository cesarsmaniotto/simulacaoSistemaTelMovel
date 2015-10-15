package modelo.distribuicao;

import java.util.Random;

public class Triangular implements Distribuicao {

	private Random random = new Random();
	private double minimo;
	private double maximo;
	private double moda;
	
	public Triangular(double minimo, double maximo, double moda) {
		super();
		this.minimo = minimo;
		this.maximo = maximo;
		this.moda = moda;
	}
	
	public double geraValor(){
		
		double aleatory = random.nextDouble();
		
		if(aleatory <= ((maximo-minimo)/(moda-minimo))){
			return minimo + Math.sqrt(aleatory*(maximo-minimo)*(moda-minimo));
		}
		
		return moda - Math.sqrt((1-aleatory)*(moda-maximo)*(moda-minimo));
		
		
	}
	
	


}