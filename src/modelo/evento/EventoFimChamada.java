package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Celula;
import modelo.Estado;

public class EventoFimChamada extends Evento {

	private Celula cel;
	private long duracaoChamada;

	public EventoFimChamada(LocalTime tempoInicio, Celula cel,
			long duracaoChamada) {
		super(tempoInicio);
		this.cel = cel;
		this.duracaoChamada = duracaoChamada;

	}

	@Override
	public Estado processaEvento(CalendarioEventos calEventos,
			Estado estadoAtual) {

		estadoAtual.decrementaOcupacaoCanal(cel.getId());

		cel.incrementaLigacoesCompletadas();

		cel.adicionaDuracaoChamada(duracaoChamada);

		return new Estado(estadoAtual);

	}
}