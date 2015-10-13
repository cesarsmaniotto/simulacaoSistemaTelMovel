package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.TreeSet;

import modelo.evento.Evento;
import modelo.evento.EventoFimSimulacao;
import modelo.evento.EventoInicioSimulacao;

public class CalendarioEventos {

	private LocalTime tempoMaximoSimulacao;
	private ArrayList<Evento> listaEventosFinalizados;
	private TreeSet<Evento> listaProximosEventos;
	private static CalendarioEventos calendarioEventosInstance;

	private CalendarioEventos() {
		this.listaEventosFinalizados = new ArrayList<Evento>();
		this.listaProximosEventos = new TreeSet<Evento>();
	}

	public static CalendarioEventos getInstance() {
		if (calendarioEventosInstance == null) {
			calendarioEventosInstance = new CalendarioEventos();
		}

		return calendarioEventosInstance;
	}

	public void iniciaSimulacao() {

		preparaInicioSimulacao();

		boolean fimSimulacao = false;
		Estado estado = new Estado();

		while (!fimSimulacao) {

			Evento ev = listaProximosEventos.first();

			if (ev instanceof EventoFimSimulacao) {
				fimSimulacao = true;
			} else {
				
				ev.setEstado(new Estado(estado));				
				ev.processaEvento();
				estado = ev.getEstado();

				listaEventosFinalizados.add(ev);

				listaProximosEventos.remove(ev);
			}

		}

	}

	private void preparaInicioSimulacao() {
		
		LocalTime inicializaRelogio = LocalTime.of(0, 0, 0);
		
		EventoInicioSimulacao inicioSimulacao = new EventoInicioSimulacao(inicializaRelogio);
		listaProximosEventos.add(inicioSimulacao);

		EventoFimSimulacao fimSimulacao = new EventoFimSimulacao(tempoMaximoSimulacao);
		listaProximosEventos.add(fimSimulacao);
	}

	public void setTempoMaximoSimulacao(LocalTime tempoMaximoSimulacao) {
		this.tempoMaximoSimulacao = tempoMaximoSimulacao;
	}
	
	public void adicionarEvento(Evento ev){
		
		listaProximosEventos.add(ev);
		
	}

}