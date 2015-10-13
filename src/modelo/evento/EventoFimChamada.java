package modelo.evento;

import java.time.LocalTime;

import modelo.Celula;

public class EventoFimChamada extends Evento {

	
	private Celula cel;
	private long duracaoChamada;
	
	public EventoFimChamada(LocalTime tempoInicio, Celula cel,long duracaoChamada) {
		super(tempoInicio);
		this.cel = cel;
		this.duracaoChamada = duracaoChamada;
		
	}

	
	@Override
	public void processaEvento() {
		
		
		estado.decrementaOcupacaoCanal(cel.getId());
		
		cel.incrementaLigacoesCompletadas();
		
		cel.adicionaDuracaoChamada(duracaoChamada);

	}
}