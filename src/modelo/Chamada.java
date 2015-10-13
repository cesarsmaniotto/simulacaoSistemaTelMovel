package modelo;

public class Chamada {

	private long tempoDuracao;
	private TipoChamada tipo;

	public Chamada(long tempoDuracao, TipoChamada tipo) {
		super();
		this.tempoDuracao = tempoDuracao;
		this.tipo = tipo;
	}

	public long getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(long tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

	public TipoChamada getTipo() {
		return tipo;
	}

	public void setTipo(TipoChamada tipo) {
		this.tipo = tipo;
	}
	
	

}