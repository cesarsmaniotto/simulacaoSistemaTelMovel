package modelo;

import controle.AtualizacaoEvento.NotificadorEvento;
import controle.ProgressoSimulacao;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.evento.Evento;
import modelo.evento.EventoFimSimulacao;
import modelo.evento.EventoInicioSimulacao;

public class CalendarioEventos extends Thread implements Observer{

	private LocalTime tempoMaximoSimulacao;
	private HistoricoEstados historico;
	private List<Evento> listaProximosEventos;
	private Cluster cluster;
	private boolean pausado;
        private boolean fimSimulacao;
        NotificadorEvento notificador;

	public CalendarioEventos(LocalTime tempoMaximoSimulacao, Cluster cluster) {
		this.pausado = false;
		this.historico = new HistoricoEstados(tempoMaximoSimulacao);
		this.cluster = cluster;
		this.listaProximosEventos = new ArrayList<>();
		this.tempoMaximoSimulacao = tempoMaximoSimulacao;
                this.notificador = new NotificadorEvento();
	}

        @Override
	public void run() {
		preparaInicioSimulacao();
                

		fimSimulacao = false;
		Estado estado = new Estado(LocalTime.MIDNIGHT);
                
		
		while (!fimSimulacao) {
			
			verificaPausa();

			Evento ev = listaProximosEventos.get(0);

			if (ev instanceof EventoFimSimulacao) {
				fimSimulacao = true;
			}
			
			System.out.println("processando evento iniciando em " + ev.getTempoInicio());
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(CalendarioEventos.class.getName()).log(Level.SEVERE, null, ex);
                    }
			estado = ev.processaEvento(this, estado);
                        notificador.notificarEvento(estado);
                        
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

    public void adicionarObservador(Observer ob) {
        this.notificador.addObserver(ob);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("chegou aqui");
        if(arg instanceof Boolean){
            setPausado((Boolean) arg);
            
        }
        if(arg instanceof Integer){
            //mudar os sleeps conforme o valor que esta em progressosimulacao
        }
    }
    
    public boolean ehFimSimulacao(){
        return fimSimulacao;
    }

    

   
}