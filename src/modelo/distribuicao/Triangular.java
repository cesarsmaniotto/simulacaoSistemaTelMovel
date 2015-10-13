package modelo.distribuicao;

import java.util.Random;

public class Triangular implements Distribuicao {

	private Random r = new Random();
	private float a;
	private float b;
	private float c;
	
	public Triangular(float a, float b, float c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public float geraVariavel(){
		
		float random = r.nextFloat();
		
		if(random <= ((b-a)/(c-a))){
			return a + (float) Math.sqrt(random*(b-a)*(c-a));
		}
		
		return c - (float) Math.sqrt((1-random)*(c-b)*(c-a));
		
		
	}
	
	


}