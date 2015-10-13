package modelo.evento;

import java.time.LocalTime;

import modelo.Cluster;

public class EventoInicioSimulacao extends Evento {

	/**
	 * @param tempoInicio
	 * @param duracao
	 */
	public EventoInicioSimulacao(LocalTime tempoInicio) {
		super(tempoInicio);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.evento.Evento#processaEvento()
	 */
	@Override
	public void processaEvento() {
		EventoInicioChamada inicioC1 = new EventoInicioChamada(getTempoInicio(), Cluster.getInstance().getC1());

		EventoInicioChamada inicioC2 = new EventoInicioChamada(getTempoInicio(), Cluster.getInstance().getC2());
		
		calEventos.adicionarEvento(inicioC1);
		calEventos.adicionarEvento(inicioC2);

	}
}