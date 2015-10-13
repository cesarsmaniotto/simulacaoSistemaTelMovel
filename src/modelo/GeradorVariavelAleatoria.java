package modelo;

import modelo.distribuicao.Distribuicao;

public class GeradorVariavelAleatoria {

	private Distribuicao distribuicao;

	public GeradorVariavelAleatoria(Distribuicao distribuicao) {
		this.distribuicao = distribuicao;
	}

	public float gera() {
		return distribuicao.geraVariavel();
	}

}
