package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Estado {

	private HashMap<String, Integer> ocupacaoCanais;

	public Estado() {
		this.ocupacaoCanais = new HashMap<>();
	}

	public Estado(Estado est) {
		this.ocupacaoCanais = new HashMap<>(est.getOcupacaoCanais());
	}

	public HashMap<String, Integer> getOcupacaoCanais() {
		return ocupacaoCanais;
	}
	
	public int getOcupacaoCanal(String key){
		return ocupacaoCanais.get(key);
	}

	public void incrementaOcupacaoCanal(String key) {
		int valorAntigo = ocupacaoCanais.get(key);
		ocupacaoCanais.put(key, valorAntigo + 1);
	}

	public void decrementaOcupacaoCanal(String key) {
		int valorAntigo = ocupacaoCanais.get(key);
		ocupacaoCanais.put(key, valorAntigo - 1);
	}
	
	public int getNumeroLigacoesEmAndamento(){
		int somatorio = 0;
		
		ArrayList<Integer> valores = new ArrayList<>(ocupacaoCanais.values());
		
		for(Integer i : valores){
			somatorio += i;
		}
		
		return somatorio;
	}

}