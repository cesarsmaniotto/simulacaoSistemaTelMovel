package modelo.evento;

import java.time.LocalTime;

public abstract class Evento implements Comparable<Evento> {

	public LocalTime tempoInicio;


	public Evento(LocalTime tempoInicio) {
		super();
		this.tempoInicio = tempoInicio;
	}

	public LocalTime getTempoInicio() {
		return tempoInicio;
	}


	public int compareTo(Evento e) {
		return tempoInicio.compareTo(e.getTempoInicio());
	}

	public abstract void processaEvento();

}