package modelo;

import java.time.LocalTime;
import java.util.HashMap;

public class Estado {

	private HashMap<String, Integer> ocupacaoCanais;
	private LocalTime tempoInicio;
	private int ocupacaoSistema;

	public Estado(LocalTime tempoInicio) {
		this.tempoInicio = tempoInicio;
		this.ocupacaoCanais = new HashMap<>();
		this.ocupacaoSistema = 0;

	}

	public Estado(Estado est, LocalTime tempoInicio) {
		this.ocupacaoSistema = est.getOcupacaoSistema();
		this.tempoInicio = tempoInicio;
		this.ocupacaoCanais = new HashMap<>(est.getOcupacaoCanais());
	}

	public int getOcupacaoSistema() {
		return ocupacaoSistema;
	}

	public HashMap<String, Integer> getOcupacaoCanais() {
		return ocupacaoCanais;
	}

	public int getOcupacaoCanal(String idCelula) {

		if (!ocupacaoCanais.containsKey(idCelula)) {
			ocupacaoCanais.put(idCelula, 0);
		} 
		
		return ocupacaoCanais.get(idCelula);
	}

	public LocalTime getTempoInicio() {
		return tempoInicio;
	}

	public void incrementaOcupacaoCanal(String idCelula) {

		int valorAntigo = ocupacaoCanais.get(idCelula);
		ocupacaoCanais.put(idCelula, valorAntigo + 1);

		ocupacaoSistema += 1;
	}

	public void decrementaOcupacaoCanal(String idCelula) {
		int valorAntigo = ocupacaoCanais.get(idCelula);
		ocupacaoCanais.put(idCelula, valorAntigo - 1);
		ocupacaoSistema -= 1;
	}

}