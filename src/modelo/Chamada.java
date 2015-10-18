package modelo;

public class Chamada {

	private long tempoDuracao;
	private TipoChamada tipo;
	private Celula origem;
	private Celula destino;

	public Chamada(Celula origem, Celula destino, long tempoDuracao,
			TipoChamada tipo) {
		super();
		this.tempoDuracao = tempoDuracao;
		this.tipo = tipo;
		this.origem = origem;
		this.destino = destino;
	}

	public long getTempoDuracao() {
		return tempoDuracao;
	}

	public TipoChamada getTipo() {
		return tipo;
	}

	public Celula getOrigem() {
		return origem;
	}

	public void setOrigem(Celula origem) {
		this.origem = origem;
	}

	public Celula getDestino() {
		return destino;
	}

	public void setDestino(Celula destino) {
		this.destino = destino;
	}

}