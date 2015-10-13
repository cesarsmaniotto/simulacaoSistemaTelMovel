package modelo.evento;

import java.time.LocalTime;

import modelo.Celula;
import modelo.Chamada;

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
	public void processaEvento() {

		Chamada chamada = cel.geraNovaChamada();

		if (estado.getOcupacaoCanal(cel.getId()) < cel.getNroCanais()) {
				
				
			switch (chamada.getTipo()) {
			case COMECA_E_TERMINA_NA_MESMA_CELULA:
				
				EventoFimChamada fimChamada = new EventoFimChamada(getTempoInicio().plusSeconds(chamada.getTempoDuracao()),
						cel,chamada.getTempoDuracao());

				calEventos.adicionarEvento(fimChamada);
				
				break;

			case TERMINA_EM_UMA_CELULA_DIFERENTE:

				EventoMudancaCanal mudancaCanal = new EventoMudancaCanal(getTempoInicio().plusSeconds(chamada.getTempoDuracao() / 2), cel.getOutraCelula(),chamada.getTempoDuracao());

				calEventos.adicionarEvento(mudancaCanal);
				
				break;
				
			case TERMINA_FORA_DA_AREA_DE_COBERTURA:
				
				EventoMudancaCanal saidaArea = new EventoMudancaCanal(getTempoInicio().plusSeconds(chamada.getTempoDuracao() / 2), cel,chamada.getTempoDuracao());

				calEventos.adicionarEvento(saidaArea);
				
				break;
			}	

			estado.incrementaOcupacaoCanal(cel.getId());

			EventoInicioChamada novaChamada = new EventoInicioChamada(
					this.tempoInicio.plusSeconds(cel.tempoParaNovaChamada()), cel);

			calEventos.adicionarEvento(novaChamada);

		} else {

			cel.incrementaLigacoesPerdidasFaltaDeCanais();

		}

	}
}