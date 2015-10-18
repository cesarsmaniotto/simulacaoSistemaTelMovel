package modelo;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class SorteioDeChamadas {

	private float percentualComecaTermina;
	private float percentualSaiDaArea;
	private float percentualMudaCelula;
	private GeradorVariavelAleatoria gerVarAleatoria;
	private Celula cel;
	private Random random;

	public SorteioDeChamadas(Celula cel, GeradorVariavelAleatoria gerVarAleatoria, float percentualComecaTermina,
			float percentualMudaCelula, float percentualSaiDaArea
			) {
		super();
		this.percentualComecaTermina = percentualComecaTermina;
		this.percentualSaiDaArea = percentualSaiDaArea;
		this.percentualMudaCelula = percentualMudaCelula;
		this.gerVarAleatoria = gerVarAleatoria;
		this.cel = cel;
		this.random = new Random();
	}

	public Chamada sorteia() {

		float aleatory = random.nextFloat();
		long duracao = (long) gerVarAleatoria.gera();

		if (aleatory <= percentualComecaTermina) {
			return new Chamada(cel, cel, duracao, TipoChamada.COMECA_E_TERMINA_NA_MESMA_CELULA);
		}
		if (aleatory <= (percentualComecaTermina + percentualMudaCelula)) {
				
			int sorteiaDestino = random.nextInt(cel.getConexoes().size());
					
			return new Chamada(cel, cel.getConexoes().get(sorteiaDestino), duracao, TipoChamada.TERMINA_EM_UMA_CELULA_DIFERENTE);
		}

		return new Chamada(cel, null, duracao,TipoChamada.TERMINA_FORA_DA_AREA_DE_COBERTURA);
	}

}