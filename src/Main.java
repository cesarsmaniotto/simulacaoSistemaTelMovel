import java.time.LocalTime;

import modelo.GeradorVariavelAleatoria;
import modelo.distribuicao.Exponencial;
import modelo.distribuicao.Uniforme;
import controle.Fachada;
import visao.FormProporcaoTipoChamada;
import visao.JanelaPrincipal;





/**
 * 
 */

/**
 * @author cesar
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		String c1 = "C1";
		String c2 = "C2";
		
		Fachada fachada = new Fachada();
                
                
        
                
		
		fachada.definirTempoSimulacao(LocalTime.of(0, 30, 0));
		
		fachada.definirNumeroCanaisCelula(c1, 2);
		fachada.definirNumeroCanaisCelula(c2, 3);
		
		fachada.definirTempoEntreChegadas(c1, new GeradorVariavelAleatoria(new Exponencial(100)));
		fachada.definirTempoEntreChegadas(c2, new GeradorVariavelAleatoria(new Exponencial(120)));
		
		fachada.definirTemposChamada(c1, 0.5f, 0.4f, 0.1f, new GeradorVariavelAleatoria(new Uniforme(180, 450)));
		fachada.definirTemposChamada(c2, 0.5f, 0.4f, 0.1f, new GeradorVariavelAleatoria(new Uniforme(180, 500)));
		
		fachada.iniciarSimulacao();
		
		
		
		fachada.obterRelatorio();
	}

}