package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.TreeSet;

import modelo.evento.Evento;
import modelo.evento.EventoInicioChamada;

public class CalendarioEventos extends Thread{

	private LocalTime tempoMaximoSimulacao;
	private ArrayList<Estado> estadosDaSimulacao;
	private TreeSet<Evento> listaProximosEventos;

	public CalendarioEventos(LocalTime tempoMaximoSimulacao) {
		this.estadosDaSimulacao = new ArrayList<>();
		this.listaProximosEventos = new TreeSet<>();
		this.tempoMaximoSimulacao = tempoMaximoSimulacao;
	}
	
	public void run(){
		iniciaSimulacao();
	}

	public void iniciaSimulacao() {

		preparaInicioSimulacao();

		boolean fimSimulacao = false;
		Estado estado = null;

		while (!fimSimulacao) {

			Evento ev = listaProximosEventos.first();

			if (ev.getTempoInicio().isAfter(tempoMaximoSimulacao)) {
				fimSimulacao = true;
			} else {

				estado = ev.processaEvento(this, estado);

				estadosDaSimulacao.add(estado);

				listaProximosEventos.remove(ev);
			}

		}

	}

	private void preparaInicioSimulacao() {

		LocalTime relogioInicial = LocalTime.of(0, 0, 0);
			
		this.adicionarEvento(new EventoInicioChamada(relogioInicial, Cluster.getInstance().getC1()));
		this.adicionarEvento(new EventoInicioChamada(relogioInicial, Cluster.getInstance().getC2()));
		
	}

	public void adicionarEvento(Evento ev) {

		listaProximosEventos.add(ev);

	}

}