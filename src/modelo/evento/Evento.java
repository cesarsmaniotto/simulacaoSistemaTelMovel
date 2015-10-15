package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Estado;

public abstract class Evento implements Comparable<Evento> {

	protected LocalTime tempoInicio;
	
	public Evento(LocalTime tempoInicio) {

 		this.tempoInicio = tempoInicio;
 	}

	public LocalTime getTempoInicio() {
		return tempoInicio;
	}

	public int compareTo(Evento e) {
		return tempoInicio.compareTo(e.getTempoInicio());
	}

	public abstract Estado processaEvento(CalendarioEventos calEventos, Estado estadoAtual);

}