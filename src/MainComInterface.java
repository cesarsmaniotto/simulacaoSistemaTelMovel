
import java.time.LocalTime;

import modelo.GeradorVariavelAleatoria;
import modelo.distribuicao.Exponencial;

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
public class MainComInterface {

    public static void main(String[] args) {

        String c1 = "C1";
        String c2 = "C2";
        int tempoSimulação = 0;
        int numeroCanaisC1,numeroCanaisC2;
        float c1c1,c1c2,c1FA,c2c2,c2c1,c2FA;
        
        
        
        
        JanelaPrincipal jp = new JanelaPrincipal();
        jp.setVisible(true);
        FormProporcaoTipoChamada fp;
        while(!jp.definido){
        }
        if (jp.definido) {
            fp = jp.getProporcao();
            tempoSimulação = fp.getTempoSimulacao();
            Fachada fachada = new Fachada();
            fachada.definirTempoSimulacao(LocalTime.of(0, tempoSimulação, 0));
            
            numeroCanaisC1 = fp.getQttLinhasC1();
            numeroCanaisC2 = fp.getQttLinhasC2();
            fachada.definirNumeroCanaisCelula(c1, numeroCanaisC1);
            fachada.definirNumeroCanaisCelula(c2, numeroCanaisC2);

            fachada.definirTempoEntreChegadas(c1, new GeradorVariavelAleatoria(new Exponencial(jp.getTEC1())));
            fachada.definirTempoEntreChegadas(c2, new GeradorVariavelAleatoria(new Exponencial(jp.getTEC2())));

            c1c1 = (float)fp.getProporcaoC1C1()/100;
            c1c2 = (float)fp.getProporcaoC1C2()/100;
            c1FA = (float)fp.getProporcaoC1FA()/100;
            
            c2c2 = (float)fp.getProporcaoC2C2()/100;
            c2c1 = (float)fp.getProporcaoC2C1()/100;
            c2FA = (float)fp.getProporcaoC2FA()/100;            
            
            fachada.definirTemposChamada(c1, c1c1, c1c2, c1FA, new GeradorVariavelAleatoria(jp.getDistriuicaoChamadasC1()));
            fachada.definirTemposChamada(c2, c2c2, c2c1, c2FA, new GeradorVariavelAleatoria(jp.getDistriuicaoChamadasC2()));

            fachada.iniciarSimulacao();

            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            fachada.pausarSimulacao();

            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            fachada.continuarSimulacao();

            fachada.obterRelatorio();
        }

    }

}
