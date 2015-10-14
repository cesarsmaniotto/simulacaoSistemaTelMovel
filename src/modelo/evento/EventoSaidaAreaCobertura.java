package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Celula;
import modelo.Estado;

public class EventoSaidaAreaCobertura extends Evento {

	private Celula cel;
	private long duracaoChamada;
	
	public EventoSaidaAreaCobertura(LocalTime tempoInicio, Celula cel, long duracaoChamada) {
		super(tempoInicio);
		this.cel = cel;
		this.duracaoChamada = duracaoChamada;
	}
	
	@Override
	public Estado processaEvento(CalendarioEventos calEventos, Estado estadoAtual){
		
		cel.incrementaLigacoesPerdidasForaDeArea();
		
		cel.adicionaDuracaoChamada(duracaoChamada / 2);
		
		estadoAtual.decrementaOcupacaoCanal(cel.getId());
		
		return estadoAtual;
		
	}

}
