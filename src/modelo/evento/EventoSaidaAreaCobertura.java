package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Celula;
import modelo.Chamada;
import modelo.Cluster;
import modelo.Estado;

public class EventoSaidaAreaCobertura extends Evento {

	private Chamada chamada;
	private Cluster cluster;
	
	public EventoSaidaAreaCobertura(LocalTime tempoInicio, Chamada chamada,
			Cluster cluster) {
		super(tempoInicio);
		this.chamada = chamada;
		this.cluster = cluster;
	}
	
	@Override
	public Estado processaEvento(CalendarioEventos calEventos, Estado estadoAtual){
		
		Celula celOrigem = cluster.getCelula(chamada.getOrigem().getId());
		
		celOrigem.incrementaLigacoesPerdidasForaDeArea();
		
		celOrigem.adicionaDuracaoChamada(chamada.getTempoDuracao() / 2);
		
		estadoAtual.decrementaOcupacaoCanal(celOrigem.getId());
		
		cluster.atualizaCelula(celOrigem);
		
		return new Estado(estadoAtual, getTempoInicio());
		
	}

    @Override
    public String toString() {
        return chamada.getOrigem().getId()+"FA "+chamada.getTempoDuracao();
    }
        



	

}
