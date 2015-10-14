package modelo;

public class SorteioDeChamadas {

	private float percentualComecaTermina;
	private float percentualSaiDaArea;
	private float percentualMudaCelula;
	private GeradorVariavelAleatoria gerVarAleatoria;

	public SorteioDeChamadas(float percentualComecaTermina,
			float percentualMudaCelula, float percentualSaiDaArea,
			GeradorVariavelAleatoria gerVarAleatoria) {
		super();
		this.percentualComecaTermina = percentualComecaTermina;
		this.percentualSaiDaArea = percentualSaiDaArea;
		this.percentualMudaCelula = percentualMudaCelula;
		this.gerVarAleatoria = gerVarAleatoria;
	}

	public Chamada sorteia() {

		float random = (float) Math.random();
		long duracao = (long) gerVarAleatoria.gera();

		if (random <= percentualComecaTermina) {
			return new Chamada(duracao, TipoChamada.COMECA_E_TERMINA_NA_MESMA_CELULA);
		}
		if (random <= (percentualComecaTermina + percentualMudaCelula)) {
			return new Chamada(duracao, TipoChamada.TERMINA_EM_UMA_CELULA_DIFERENTE);
		}

		return new Chamada(duracao,TipoChamada.TERMINA_FORA_DA_AREA_DE_COBERTURA);
	}

}