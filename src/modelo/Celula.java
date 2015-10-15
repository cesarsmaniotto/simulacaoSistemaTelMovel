package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Celula {

	private int nroCanais;
	public String id;
	private List<Long> listaTemposChamada;
	private int qttLigacoesCompletadas;
	private int qttLigacoesPerdidasFaltaDeCanais;
	private int qttLigacoesPerdidasForaDeArea;
	private Celula outraCelula;
	private SorteioDeChamadas geradorDeChamadas;
	private GeradorVariavelAleatoria gerVarAleatoria;

	/**
	 * 
	 */
	public Celula(String id) {
		this.id = id;
		this.qttLigacoesCompletadas = 0;
		this.qttLigacoesPerdidasFaltaDeCanais = 0;
		this.qttLigacoesPerdidasForaDeArea = 0;
		this.listaTemposChamada = new ArrayList<Long>();

	}

	public int getNroCanais() {
		return nroCanais;
	}

	public void setNroCanais(int nroCanais) {
		this.nroCanais = nroCanais;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Long> getListaTemposChamada() {
		return listaTemposChamada;
	}

	public void setListaTemposChamada(List<Long> listaTemposChamada) {
		this.listaTemposChamada = listaTemposChamada;
	}

	public int getQttLigacoesCompletadas() {
		return qttLigacoesCompletadas;
	}

	public int getQttLigacoesPerdidasFaltaDeCanais() {
		return qttLigacoesPerdidasFaltaDeCanais;
	}

	public int getQttLigacoesPerdidasForaDeArea() {
		return qttLigacoesPerdidasForaDeArea;
	}

	public Celula getOutraCelula() {
		return outraCelula;
	}

	public void setOutraCelula(Celula outraCelula) {
		this.outraCelula = outraCelula;
	}

	public SorteioDeChamadas getGeradorDeChamadas() {
		return geradorDeChamadas;
	}

	public void setGeradorDeChamadas(SorteioDeChamadas geradorDeChamadas) {
		this.geradorDeChamadas = geradorDeChamadas;
	}

	public GeradorVariavelAleatoria getGerVarAleatoria() {
		return gerVarAleatoria;
	}

	public void setGerVarAleatoria(GeradorVariavelAleatoria gerVarAleatoria) {
		this.gerVarAleatoria = gerVarAleatoria;
	}


	public Chamada geraNovaChamada() {
		return geradorDeChamadas.sorteia();
	}
	
	public long tempoParaNovaChamada(){
		return (long) gerVarAleatoria.gera();
	}
	
	public void incrementaLigacoesPerdidasFaltaDeCanais(){
		qttLigacoesPerdidasFaltaDeCanais += 1;
	}
	
	public void incrementaLigacoesPerdidasForaDeArea(){
		qttLigacoesPerdidasForaDeArea += 1;
	}
	
	public void incrementaLigacoesCompletadas(){
		qttLigacoesCompletadas += 1;
	}
	
	public void adicionaDuracaoChamada(long duracaoChamada){
		listaTemposChamada.add(duracaoChamada);
	}
	
	public long getTempoChamadaMaiorDuracao(){
		return Collections.max(listaTemposChamada);
	}
	
	public long getTempoChamadaMenorDuracao(){
		return Collections.min(listaTemposChamada);
	}
	
	public long getTempoMedioDuracaoChamada(){
		
		long somatorio = 0;
		
		for(long tempo : listaTemposChamada){
			
			somatorio += tempo;
			
		}
		
		return somatorio / listaTemposChamada.size();	
		
	}
	
	

}