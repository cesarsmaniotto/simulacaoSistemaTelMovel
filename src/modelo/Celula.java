package modelo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Celula {

	private int nroCanais;
	private String id;
	private List<Long> listaTemposChamada;
	private int qttLigacoesCompletadas;
	private int qttLigacoesPerdidasFaltaDeCanais;
	private int qttLigacoesPerdidasForaDeArea;
	private List<Celula> conexoes;
	private SorteioDeChamadas geradorDeChamadas;
	private GeradorVariavelAleatoria tempoEntreChamadas;

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

	public List<Celula> getConexoes() {
		return conexoes;
	}

	public void setConexoes(List<Celula> conexoes) {
		this.conexoes = conexoes;
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


	public SorteioDeChamadas getGeradorDeChamadas() {
		return geradorDeChamadas;
	}

	public void setGeradorDeChamadas(SorteioDeChamadas geradorDeChamadas) {
		this.geradorDeChamadas = geradorDeChamadas;
	}

	public GeradorVariavelAleatoria getTempoEntreChamadas() {
		return tempoEntreChamadas;
	}

	public void setTempoEntreChamadas(GeradorVariavelAleatoria tempoEntreChamadas) {
		this.tempoEntreChamadas = tempoEntreChamadas;
	}


	public Chamada geraNovaChamada() {
		return geradorDeChamadas.sorteia();
	}
	
	public long tempoParaNovaChamada(){
		return (long) tempoEntreChamadas.gera();
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
	
	public LocalTime getTempoChamadaMaiorDuracao(){
		return LocalTime.MIDNIGHT.plusSeconds(Collections.max(listaTemposChamada));
	}
	
	public LocalTime getTempoChamadaMenorDuracao(){
		return LocalTime.MIDNIGHT.plusSeconds(Collections.min(listaTemposChamada));
	}
	
	public LocalTime getTempoMedioDuracaoChamada(){
		
		long somatorio = 0;
		
		for(long tempo : listaTemposChamada){
			
			somatorio += tempo;
			
		}
		
		return LocalTime.MIDNIGHT.plusSeconds(somatorio / listaTemposChamada.size());	
		
	}
	
	

}