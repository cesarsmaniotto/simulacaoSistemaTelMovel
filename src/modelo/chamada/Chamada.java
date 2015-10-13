package modelo.chamada;

import modelo.Celula;

public abstract class Chamada {

	private int tempoDuracao;
	private Celula origem;

	public Chamada(int tempoDuracao, Celula origem) {
		super();
		this.tempoDuracao = tempoDuracao;
		this.origem = origem;
	}

}