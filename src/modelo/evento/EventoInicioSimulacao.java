package modelo.evento;

import java.time.LocalTime;
import modelo.CalendarioEventos;
import modelo.Celula;
import modelo.Cluster;
import modelo.Estado;

public class EventoInicioSimulacao extends Evento{

	private Cluster cluster;

	public EventoInicioSimulacao(LocalTime tempoInicio, Cluster cluster) {
		super(tempoInicio);
		this.cluster = cluster;
	}

	@Override
	public Estado processaEvento(CalendarioEventos calEventos, Estado estadoAtual) {
	
		for(Celula cel : cluster.getCelulas()){
			calEventos.adicionarEvento(new EventoInicioChamada(getTempoInicio(), cluster, cel.getId()));
		}
		
		return new Estado(estadoAtual, getTempoInicio());
	}

    @Override
    public String toString() {
        return "INICIO";
    }
        

}
