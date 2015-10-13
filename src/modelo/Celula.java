package modelo;

import java.util.ArrayList;
import java.util.Date;

import modelo.distribuicao.Distribuicao;

public class Celula {

	private int nroCanais;

	public String id;

	private ArrayList<Integer> listaTemposChamada;

	private int qttLigacoesCompletadas;

	private int qttLigacoesPerdidasFaltaDeCanais;

	private int qttLigacoesPerdidasForaDeArea;

	private GeradorDeChamadas geradorDeChamadas;
	
	private Distribuicao tempoEntreChegadas;
	
	/**
	 * 
	 */
	public Celula(String id) {
		this.id = id;
		this.qttLigacoesCompletadas = 0;
		this.qttLigacoesPerdidasFaltaDeCanais = 0;
		this.qttLigacoesPerdidasForaDeArea = 0;
		this.listaTemposChamada = new ArrayList<Integer>();
		
	}

	public void setNroCanais(int nroCanais) {
		this.nroCanais = nroCanais;
	}

	public void setGeradorDeChamadas(GeradorDeChamadas geradorDeChamadas) {
		this.geradorDeChamadas = geradorDeChamadas;
	}

	public void setTempoEntreChegadas(Distribuicao tempoEntreChegadas) {
		this.tempoEntreChegadas = tempoEntreChegadas;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
	

}