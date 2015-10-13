package modelo;


public class Cluster {

	private Celula c1;
	
	private Celula c2;
	
	private static Cluster clusterInstance;
	
	/**
	 * 
	 */
	private Cluster() {
		c1 = new Celula("C1");
		c2 = new Celula("C2");
		c1.setOutraCelula(c2);
		c2.setOutraCelula(c1);
	}
	
	public static Cluster getInstance(){
		
		if(clusterInstance == null){
			clusterInstance = new Cluster();
		}
		
		return clusterInstance;
		
	}
	
	public Celula getC1() {
		return c1;
	}

	public void setC1(Celula c1) {
		this.c1 = c1;
	}

	public Celula getC2() {
		return c2;
	}

	public void setC2(Celula c2) {
		this.c2 = c2;
	}
	
	

}