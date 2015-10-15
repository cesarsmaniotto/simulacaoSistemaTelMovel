package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Cluster;
import modelo.Estado;

public class EventoInicioSimulacao extends Evento{

	

	public EventoInicioSimulacao(LocalTime tempoInicio) {
		super(tempoInicio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Estado processaEvento(CalendarioEventos calEventos, Estado estadoAtual) {
		EventoInicioChamada inicioC1 = new EventoInicioChamada(getTempoInicio(), Cluster.getInstance().getC1());
		EventoInicioChamada inicioC2 = new EventoInicioChamada(getTempoInicio(), Cluster.getInstance().getC2());
		 		
		calEventos.adicionarEvento(inicioC1);
		calEventos.adicionarEvento(inicioC2);
		
		return new Estado(estadoAtual);
	}

}
