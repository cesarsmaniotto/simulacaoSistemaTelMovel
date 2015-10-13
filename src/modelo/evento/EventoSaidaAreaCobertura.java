package modelo.evento;

import java.time.LocalTime;

import modelo.Celula;

public class EventoSaidaAreaCobertura extends Evento {

	private Celula cel;
	private long duracaoChamada;
	
	public EventoSaidaAreaCobertura(LocalTime tempoInicio, Celula cel, long duracaoChamada) {
		super(tempoInicio);
		this.cel = cel;
		this.duracaoChamada = duracaoChamada;
	}
	
	@Override
	public void processaEvento() {
		
		cel.incrementaLigacoesPerdidasForaDeArea();
		
		cel.adicionaDuracaoChamada(duracaoChamada / 2);
		
		estado.decrementaOcupacaoCanal(cel.getId());
		
		
	}

}
