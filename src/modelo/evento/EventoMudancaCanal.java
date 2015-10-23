package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Celula;
import modelo.Chamada;
import modelo.Cluster;
import modelo.Estado;

public class EventoMudancaCanal extends Evento {

	private Chamada chamada;
	private Cluster cluster;

	public EventoMudancaCanal(LocalTime tempoInicio, Chamada chamada,
			Cluster cluster) {
		super(tempoInicio);
		this.chamada = chamada;
		this.cluster = cluster;
	}

	@Override
	public Estado processaEvento(CalendarioEventos calEventos,
			Estado estadoAtual) {
		
		Celula celOrigem = cluster.getCelula(chamada.getOrigem().getId());
		Celula celDestino = cluster.getCelula(chamada.getDestino().getId());

		if (estadoAtual.getOcupacaoCanal(celDestino.getId()) < celDestino.getNroCanais()) {

			LocalTime inicioProxEvento = getTempoInicio().plusSeconds(
					chamada.getTempoDuracao() / 2);

			calEventos.adicionarEvento(new EventoFimChamada(inicioProxEvento,
					chamada, cluster));
			
			estadoAtual.incrementaOcupacaoCanal(celDestino.getId());

		} else {
			celDestino.incrementaLigacoesPerdidasFaltaDeCanais();

			celDestino.adicionaDuracaoChamada(
					chamada.getTempoDuracao() / 2);
			
			cluster.atualizaCelula(celDestino);
		}

		estadoAtual.decrementaOcupacaoCanal(celOrigem.getId());

		return new Estado(estadoAtual, getTempoInicio());
	}

    @Override
    public String toString() {
        return "MUDANCA:"+chamada.getOrigem().getId()+chamada.getDestino().getId();
    }
        
}