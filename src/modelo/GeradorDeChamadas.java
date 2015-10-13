package modelo;

import java.util.Date;
import java.util.Random;
import java.util.Vector;

import modelo.chamada.Chamada;
import modelo.chamada.ComecaTerminaMesmaCelula;
import modelo.chamada.SaiDaAreaDeCobertura;
import modelo.chamada.TerminaEmOutraCelula;
import modelo.distribuicao.Distribuicao;

public class GeradorDeChamadas {

	private float percentualComecaTermina;

	private float percentualSaiDaArea;

	private float percentualMudaCelula;

	private Distribuicao dist;

	private Celula celulaOrigem;

	public GeradorDeChamadas(float percentualComecaTermina,
			float percentualMudaCelula, float percentualSaiDaArea,
			Distribuicao dist) {
		super();
		this.percentualComecaTermina = percentualComecaTermina;
		this.percentualSaiDaArea = percentualSaiDaArea;
		this.percentualMudaCelula = percentualMudaCelula;
		this.dist = dist;
	}

	public Celula getCelulaOrigem() {
		return celulaOrigem;
	}

	public void setCelulaOrigem(Celula celulaOrigem) {
		this.celulaOrigem = celulaOrigem;
	}

	public Chamada geraProxima() {

		float random = (float) Math.random();
		int duracao = (int) dist.geraVariavel();

		if (random <= percentualComecaTermina) {
			return new ComecaTerminaMesmaCelula(duracao, getCelulaOrigem());
		}
		if (random <= (percentualComecaTermina + percentualMudaCelula)) {
			return new TerminaEmOutraCelula(duracao,getCelulaOrigem());
		}

		return new SaiDaAreaDeCobertura(duracao,getCelulaOrigem());
	}

}