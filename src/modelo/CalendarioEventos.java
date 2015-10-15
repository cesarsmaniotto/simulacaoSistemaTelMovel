package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.TreeSet;

import modelo.evento.Evento;
import modelo.evento.EventoFimSimulacao;
import modelo.evento.EventoInicioChamada;
import modelo.evento.EventoInicioSimulacao;

public class CalendarioEventos extends Thread {

	private LocalTime tempoMaximoSimulacao;
	private HistoricoEstados historico;
	private TreeSet<Evento> listaProximosEventos;

	public CalendarioEventos(LocalTime tempoMaximoSimulacao) {
		this.historico = new HistoricoEstados();
		this.listaProximosEventos = new TreeSet<>();
		this.tempoMaximoSimulacao = tempoMaximoSimulacao;
	}

	public void run() {
		iniciaSimulacao();
	}

	public void iniciaSimulacao() {

		preparaInicioSimulacao();

		boolean fimSimulacao = false;
		Estado estado = null;

		while (!fimSimulacao) {

			Evento ev = listaProximosEventos.first();

			if (ev instanceof EventoFimSimulacao) {
				fimSimulacao = true;
			}

			estado = ev.processaEvento(this, estado);

			historico.adicionarEstado(estado);

			listaProximosEventos.remove(ev);

		}

	}

	private void preparaInicioSimulacao() {

		LocalTime relogioInicial = LocalTime.of(0, 0, 0);
		this.adicionarEvento(new EventoInicioSimulacao(relogioInicial));
		this.adicionarEvento(new EventoFimSimulacao(tempoMaximoSimulacao));

	}

	public void adicionarEvento(Evento ev) {

		listaProximosEventos.add(ev);

	}

}