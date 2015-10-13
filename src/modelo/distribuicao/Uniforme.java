package modelo.distribuicao;

import java.util.Random;

public class Uniforme implements Distribuicao {
	
	private Random r = new Random();
	private float a;
	private float b;

	public Uniforme(float a, float b) {
		super();
		this.a = a;
		this.b = b;
	}

	public float geraVariavel() {

		float random = r.nextFloat();

		return a + ((b - a) * random);
	}

}