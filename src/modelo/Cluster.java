package modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cluster {

	private Map<String,Celula> celulas;

	public Cluster(int qttCelulas) {

		this.celulas = new HashMap<>();

		for (int i = 1; i <= qttCelulas; i++) {
			celulas.put("C" + i,new Celula("C" + i));
		}

		for (Celula cel : celulas.values()) {

			List<Celula> conexoes = new ArrayList<>(celulas.values());
			conexoes.remove(cel);

			cel.setConexoes(conexoes);

		}

	}

	public Collection<Celula> getCelulas() {
		return celulas.values();
	}

	public void setCelulas(Map<String, Celula> celulas) {
		this.celulas = celulas;
	}
	
	public Celula getCelula(String id){
		return celulas.get(id);
	}
	
	public void atualizaCelula(Celula cel){
		celulas.put(cel.getId(), cel);
	}

	

}