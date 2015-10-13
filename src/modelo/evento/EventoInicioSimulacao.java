package modelo.evento;

import java.time.LocalTime;

public class EventoInicioSimulacao extends Evento {

	/**
	 * @param tempoInicio
	 * @param duracao
	 */
	public EventoInicioSimulacao(LocalTime tempoInicio) {
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