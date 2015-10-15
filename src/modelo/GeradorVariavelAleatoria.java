package modelo;

import modelo.distribuicao.Distribuicao;

public class GeradorVariavelAleatoria {

	private Distribuicao distribuicao;

	public GeradorVariavelAleatoria(Distribuicao distribuicao) {
		this.distribuicao = distribuicao;
	}

	public double gera() {
		return distribuicao.geraValor();
	}

}
