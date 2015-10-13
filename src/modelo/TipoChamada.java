package modelo;

public enum TipoChamada {
	
	COMECA_E_TERMINA_NA_MESMA_CELULA(1),
	TERMINA_EM_UMA_CELULA_DIFERENTE(2),
	TERMINA_FORA_DA_AREA_DE_COBERTURA(3);
	
	private int tipo;
	
	private TipoChamada(int tipo) {
		this.setTipo(tipo);
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	

}
