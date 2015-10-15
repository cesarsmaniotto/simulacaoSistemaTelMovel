package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Celula;
import modelo.Chamada;
import modelo.Estado;

public class EventoInicioChamada extends Evento {

	/**
	 * @param tempoInicio
	 * @param duracao
	 */
	private Celula cel;

	public EventoInicioChamada(LocalTime tempoInicio, Celula cel) {
		super(tempoInicio);
		this.cel = cel;

	}

	@Override
	public Estado processaEvento(CalendarioEventos calEventos, Estado estadoAtual) {

		Chamada chamada = cel.geraNovaChamada();

		if (estadoAtual.getOcupacaoCanal(cel.getId()) < cel.getNroCanais()) {

			Evento proximoEvento = null;

			switch (chamada.getTipo()) {
			case COMECA_E_TERMINA_NA_MESMA_CELULA:
				
				proximoEvento = new EventoFimChamada(getTempoInicio().plusSeconds(chamada.getTempoDuracao()), cel,
						chamada.getTempoDuracao());
				break;

			case TERMINA_EM_UMA_CELULA_DIFERENTE:

				proximoEvento = new EventoMudancaCanal(getTempoInicio().plusSeconds(chamada.getTempoDuracao() / 2),
						cel.getOutraCelula(), chamada.getTempoDuracao());
				break;

			case TERMINA_FORA_DA_AREA_DE_COBERTURA:

				proximoEvento = new EventoMudancaCanal(getTempoInicio().plusSeconds(chamada.getTempoDuracao() / 2), cel,
						chamada.getTempoDuracao());
				break;

			}

			calEventos.adicionarEvento(proximoEvento);

			estadoAtual.incrementaOcupacaoCanal(cel.getId());

			calEventos.adicionarEvento(
					new EventoInicioChamada(this.tempoInicio.plusSeconds(cel.tempoParaNovaChamada()), cel));

		} else {

			cel.incrementaLigacoesPerdidasFaltaDeCanais();

		}
		
		return new Estado(estadoAtual);

	}
}