package modelo.evento;

import java.time.LocalTime;

import modelo.Celula;

public class EventoMudancaCanal extends Evento {

	private Celula cel;
	private long duracaoChamada;

	public EventoMudancaCanal(LocalTime tempoInicio, Celula cel, long duracaoChamada) {
		super(tempoInicio);
		this.cel = cel;
		this.duracaoChamada = duracaoChamada;

	}

	@Override
	public void processaEvento() {

		if (estado.getOcupacaoCanal(cel.getId()) < cel.getNroCanais()) {

			LocalTime inicioProxEvento = getTempoInicio().plusSeconds(duracaoChamada / 2);

			EventoFimChamada fimChamada = new EventoFimChamada(inicioProxEvento, cel, duracaoChamada);

			calEventos.adicionarEvento(fimChamada);

		} else {
			cel.incrementaLigacoesPerdidasFaltaDeCanais();

			cel.adicionaDuracaoChamada(duracaoChamada / 2);
		}

		estado.decrementaOcupacaoCanal(cel.getOutraCelula().getId());

	}
}