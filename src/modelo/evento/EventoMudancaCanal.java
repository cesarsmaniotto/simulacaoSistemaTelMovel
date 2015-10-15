package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Celula;
import modelo.Estado;

public class EventoMudancaCanal extends Evento {

	private Celula cel;
	private long duracaoChamada;

	public EventoMudancaCanal(LocalTime tempoInicio, Celula cel, long duracaoChamada) {
		super();
		this.cel = cel;
		this.duracaoChamada = duracaoChamada;

	}

	@Override
	public Estado processaEvento(CalendarioEventos calEventos, Estado estadoAtual) {

		if (estadoAtual.getOcupacaoCanal(cel.getId()) < cel.getNroCanais()) {

			LocalTime inicioProxEvento = getTempoInicio().plusSeconds(duracaoChamada / 2);

			calEventos.adicionarEvento(new EventoFimChamada(inicioProxEvento, cel, duracaoChamada));

		} else {
			cel.incrementaLigacoesPerdidasFaltaDeCanais();

			cel.adicionaDuracaoChamada(duracaoChamada / 2);
		}

		estadoAtual.decrementaOcupacaoCanal(cel.getOutraCelula().getId());
		
		return new Estado(estadoAtual);
	}
}