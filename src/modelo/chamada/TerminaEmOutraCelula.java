package modelo.chamada;

import modelo.Celula;
import modelo.Cluster;


public class TerminaEmOutraCelula extends Chamada {

	
	private Celula destino;
	/**
	 * @param tempoDuracao
	 */
	public TerminaEmOutraCelula(int tempoDuracao, Celula origem) {
		super(tempoDuracao, origem);
		
		if(origem.equals(Cluster.getInstance().getC1())){
			destino = Cluster.getInstance().getC2();
		}else{
			destino = Cluster.getInstance().getC1();
		}
		
	}
}