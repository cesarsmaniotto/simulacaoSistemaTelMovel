package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelo.evento.Evento;
import modelo.evento.EventoFimSimulacao;
import modelo.evento.EventoInicioSimulacao;

public class CalendarioEventos extends Thread {

	private LocalTime tempoMaximoSimulacao;
	private HistoricoEstados historico;
	private List<Evento> listaProximosEventos;
	private Cluster cluster;
	private boolean pausado;

	public CalendarioEventos(LocalTime tempoMaximoSimulacao, Cluster cluster) {
		this.pausado = false;
		this.historico = new HistoricoEstados(tempoMaximoSimulacao);
		this.cluster = cluster;
		this.listaProximosEventos = new ArrayList<>();
		this.tempoMaximoSimulacao = tempoMaximoSimulacao;
	}

	public void run() {
		preparaInicioSimulacao();

		boolean fimSimulacao = false;
		Estado estado = new Estado(LocalTime.MIDNIGHT);
		
		while (!fimSimulacao) {
			
			verificaPausa();

			Evento ev = listaProximosEventos.get(0);

			if (ev instanceof EventoFimSimulacao) {
				fimSimulacao = true;
			}
			
			System.out.println("processando evento iniciando em " + ev.getTempoInicio());

			estado = ev.processaEvento(this, estado);

			historico.adicionarEstado(estado);

			listaProximosEventos.remove(ev);
			Collections.sort(listaProximosEventos);

		}
	}

	public synchronized void verificaPausa(){
		
		while(pausado){
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public synchronized void setPausado(boolean pausado){
		
		this.pausado = pausado;
		
		if(!pausado){
			notify();
		}
		
	}
	
	
	private void preparaInicioSimulacao() {

		this.adicionarEvento(new EventoInicioSimulacao(LocalTime.MIDNIGHT, cluster));
		this.adicionarEvento(new EventoFimSimulacao(tempoMaximoSimulacao));

	}

	public void adicionarEvento(Evento ev) {

		listaProximosEventos.add(ev);

	}
	
	public HistoricoEstados getHistorico(){
		return historico;
	}

}