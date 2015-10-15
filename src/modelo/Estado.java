package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Estado {

	private HashMap<String, Integer> ocupacaoCanais;
	private LocalTime tempoInicio;

	public Estado(LocalTime tempoInicio) {
		this.tempoInicio = tempoInicio;
		this.ocupacaoCanais = new HashMap<>();
		
	}

	public Estado(Estado est) {
		this.ocupacaoCanais = new HashMap<>(est.getOcupacaoCanais());
	}

	public HashMap<String, Integer> getOcupacaoCanais() {
		return ocupacaoCanais;
	}

	public int getOcupacaoCanal(String key) {
		return ocupacaoCanais.get(key);
	}

	public LocalTime getTempoInicio() {
		return tempoInicio;
	}

	public void incrementaOcupacaoCanal(String key) {
		int valorAntigo = ocupacaoCanais.get(key);
		ocupacaoCanais.put(key, valorAntigo + 1);
	}

	public void decrementaOcupacaoCanal(String key) {
		int valorAntigo = ocupacaoCanais.get(key);
		ocupacaoCanais.put(key, valorAntigo - 1);
	}

	public int getNumeroLigacoesEmAndamento() {
		int somatorio = 0;

		ArrayList<Integer> valores = new ArrayList<>(ocupacaoCanais.values());

		for (Integer i : valores) {
			somatorio += i;
		}

		return somatorio;
	}

}