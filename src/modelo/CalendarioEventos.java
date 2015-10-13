package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import modelo.evento.Evento;
import modelo.evento.EventoFimSimulacao;
import modelo.evento.EventoInicioSimulacao;

public class CalendarioEventos {

	private LocalTime tempoMaximoSimulacao;

	private ArrayList<Evento> listaEventosFinalizados;

	private LocalTime tempoDecorrido;

	private TreeSet<Evento> listaProximosEventos;

	private static CalendarioEventos calendarioEventosInstance;

	private CalendarioEventos() {
		this.listaEventosFinalizados = new ArrayList<Evento>();
		this.listaProximosEventos = new TreeSet<Evento>();
		this.tempoDecorrido = LocalTime.of(0, 0, 0);
	}

	public static CalendarioEventos getInstance(){
		if(calendarioEventosInstance == null){
			calendarioEventosInstance = new CalendarioEventos();
		}
		
		return calendarioEventosInstance;
	}

	public void iniciaSimulacao() {

		preparaInicioSimulacao();

		boolean fimSimulacao = false;

		while (!fimSimulacao) {

			Evento ev = listaProximosEventos.first();

			if (ev instanceof EventoFimSimulacao) {
				fimSimulacao = true;
			} else {
				ev.processaEvento();

				listaEventosFinalizados.add(ev);

				listaProximosEventos.remove(ev);
			}

		}

	}

	private void preparaInicioSimulacao() {
		EventoInicioSimulacao inicioSimulacao = new EventoInicioSimulacao(
				tempoDecorrido, tempoDecorrido.plusSeconds(1));
		listaProximosEventos.add(inicioSimulacao);

		EventoFimSimulacao fimSimulacao = new EventoFimSimulacao(
				tempoMaximoSimulacao, tempoMaximoSimulacao.plusSeconds(1));
		listaProximosEventos.add(fimSimulacao);
	}

	public void setTempoMaximoSimulacao(LocalTime tempoMaximoSimulacao) {
		this.tempoMaximoSimulacao = tempoMaximoSimulacao;
	}

}