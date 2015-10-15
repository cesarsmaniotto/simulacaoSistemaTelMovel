package modelo;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoricoEstados {
	
	private List<Estado> estadosDaSimulacao;
	private LocalTime tempoSimulacao;
	
	public HistoricoEstados() {

		this.estadosDaSimulacao = new ArrayList<>();
	}
	
	public void adicionarEstado(Estado est){
		estadosDaSimulacao.add(est);
	}
	
	public float getTaxaMediaOcupacaoSistema(){
		
		Map<Integer, Long> duracaoCadaEstado = new HashMap<>();
			
		for(int i=0; i < estadosDaSimulacao.size(); i++){
			
			Estado umEstado = estadosDaSimulacao.get(i);
			Estado proximoEstado = estadosDaSimulacao.get(i+1);
			
			long tempoAteProximoEstado = umEstado.getTempoInicio().until(proximoEstado.getTempoInicio(), ChronoUnit.SECONDS);
			int nroLigacoes = umEstado.getNumeroLigacoesEmAndamento();
			
			if(duracaoCadaEstado.containsKey(nroLigacoes)){
				
				long tempoAtual = duracaoCadaEstado.get(nroLigacoes);
				duracaoCadaEstado.put(nroLigacoes, tempoAtual + tempoAteProximoEstado);
				
			}else{
				duracaoCadaEstado.put(nroLigacoes, tempoAteProximoEstado);
			}
			
		}
		
		List<Integer> nrosLigacoes = new ArrayList<>(duracaoCadaEstado.keySet());
		
		float mediaPonderada = 0;
		long tempoSimulacao = 1;
		
		for(Integer umNroLigacao : nrosLigacoes){
			mediaPonderada += umNroLigacao * (umNroLigacao / tempoSimulacao);
		}	
		
		return mediaPonderada;
	}
	
	public float getTaxaMediaOcupacaoCelula(String idCelula){
		return 0;
	}
	
	

}
