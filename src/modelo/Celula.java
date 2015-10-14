package modelo;

import java.util.ArrayList;

public class Celula {

	private int nroCanais;
	public String id;
	private ArrayList<Long> listaTemposChamada;
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

	public ArrayList<Long> getListaTemposChamada() {
		return listaTemposChamada;
	}

	public void setListaTemposChamada(ArrayList<Long> listaTemposChamada) {
		this.listaTemposChamada = listaTemposChamada;
	}

	public int getQttLigacoesCompletadas() {
		return qttLigacoesCompletadas;
	}

	public void setQttLigacoesCompletadas(int qttLigacoesCompletadas) {
		this.qttLigacoesCompletadas = qttLigacoesCompletadas;
	}

	public int getQttLigacoesPerdidasFaltaDeCanais() {
		return qttLigacoesPerdidasFaltaDeCanais;
	}

	public void setQttLigacoesPerdidasFaltaDeCanais(int qttLigacoesPerdidasFaltaDeCanais) {
		this.qttLigacoesPerdidasFaltaDeCanais = qttLigacoesPerdidasFaltaDeCanais;
	}

	public int getQttLigacoesPerdidasForaDeArea() {
		return qttLigacoesPerdidasForaDeArea;
	}

	public void setQttLigacoesPerdidasForaDeArea(int qttLigacoesPerdidasForaDeArea) {
		this.qttLigacoesPerdidasForaDeArea = qttLigacoesPerdidasForaDeArea;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
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

}