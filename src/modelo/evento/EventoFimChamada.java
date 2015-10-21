package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Celula;
import modelo.Chamada;
import modelo.Cluster;
import modelo.Estado;

public class EventoFimChamada extends Evento {

	private Chamada chamada;
	private Cluster cluster;


	public EventoFimChamada(LocalTime tempoInicio, Chamada chamada,
			Cluster cluster) {
		super(tempoInicio);
		this.chamada = chamada;
		this.cluster = cluster;

	}

	@Override
	public Estado processaEvento(CalendarioEventos calEventos,
			Estado estadoAtual) {
		
		String idDestino = chamada.getDestino().getId();

		estadoAtual.decrementaOcupacaoCanal(idDestino);
		
		Celula celDestino = cluster.getCelula(idDestino);

		celDestino.incrementaLigacoesCompletadas();

		celDestino.adicionaDuracaoChamada(chamada.getTempoDuracao());
		
		cluster.atualizaCelula(celDestino);

		return new Estado(estadoAtual, getTempoInicio());

	}

    @Override
    public String toString() {
        return "FIM:"+chamada.getOrigem().getId()+chamada.getDestino().getId()+" "+chamada.getTempoDuracao();
    }
        
}