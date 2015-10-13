package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Estado;

public abstract class Evento implements Comparable<Evento> {

	protected LocalTime tempoInicio;
	protected CalendarioEventos calEventos;
	protected Estado estado;

	public Evento(LocalTime tempoInicio) {
		super();
		this.tempoInicio = tempoInicio;
		this.calEventos = CalendarioEventos.getInstance();
	}

	public LocalTime getTempoInicio() {
		return tempoInicio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int compareTo(Evento e) {
		return tempoInicio.compareTo(e.getTempoInicio());
	}

	public void processaEvento() {
		// TODO Auto-generated method stub

	}

}