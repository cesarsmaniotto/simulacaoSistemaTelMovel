package modelo.evento;

import java.time.LocalTime;

public class EventoInicioChamada extends Evento {

	/**
	 * @param tempoInicio
	 * @param duracao
	 */
	public EventoInicioChamada(LocalTime tempoInicio) {
		super(tempoInicio);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see modelo.evento.Evento#processaEvento()
	 */
	@Override
	public void processaEvento() {
		// TODO Auto-generated method stub
		
	}
}