package modelo.evento;

import java.time.LocalTime;

import modelo.CalendarioEventos;
import modelo.Estado;

public class EventoFimSimulacao extends Evento{

	public EventoFimSimulacao(LocalTime tempoInicio) {
		super(tempoInicio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Estado processaEvento(CalendarioEventos calEventos, Estado estadoAtual) {
		
		return new Estado(estadoAtual, getTempoInicio());
	}

    @Override
    public String toString() {
        return "FIM";
    }
        

}
