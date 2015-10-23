
import java.time.LocalTime;

import modelo.GeradorVariavelAleatoria;
import modelo.distribuicao.Exponencial;

import controle.Fachada;
import modelo.distribuicao.Uniforme;
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

        JanelaPrincipal jp = new JanelaPrincipal();
        jp.setVisible(true);        
        Fachada fachada = new Fachada();
        
        while (true) {
            try {
                Thread.currentThread().sleep(20);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (jp.definido) {
                prepararSimulacao(fachada, jp);
                jp.definido = false;
                //adiciona a janela principal como observador
                fachada.adicionarObservador(jp);                
                fachada.iniciarSimulacao();
                
                while(!fachada.fimSimulacao()){
                    fachada.definirVelocidade(jp.velocidade);
                    if(jp.pausado){
                        fachada.pausarSimulacao();
                        jp.gerarRelatorio(fachada.obterRelatorio());
                        
                    }else{
                        fachada.continuarSimulacao();

                    }
                }
                
                
                jp.gerarRelatorio(fachada.obterRelatorio());
                
              

                

        

            }

        }

    }

    private static void prepararSimulacao(Fachada fachada, JanelaPrincipal jp) {
        String c1 = "C1";
        String c2 = "C2";
        int tempoSimulação;
        int numeroCanaisC1, numeroCanaisC2;
        float c1c1, c1c2, c1FA, c2c2, c2c1, c2FA;
        FormProporcaoTipoChamada fp;
        fp = jp.getProporcao();
        tempoSimulação = fp.getTempoSimulacao();                
        //tempoSimulação = 70;
        //Fachada fachada = new Fachada();
        fachada.definirTempoSimulacao(LocalTime.MIDNIGHT.plusMinutes(tempoSimulação));

                numeroCanaisC1 = fp.getQttLinhasC1();
              numeroCanaisC2 = fp.getQttLinhasC2();
//        numeroCanaisC1 = 2;
//        numeroCanaisC2 = 3;

        fachada.definirNumeroCanaisCelula(c1, numeroCanaisC1);
        fachada.definirNumeroCanaisCelula(c2, numeroCanaisC2);

        fachada.definirTempoEntreChegadas(c1, new GeradorVariavelAleatoria(new Exponencial(jp.getTEC1())));
        fachada.definirTempoEntreChegadas(c2, new GeradorVariavelAleatoria(new Exponencial(jp.getTEC2())));
        //fachada.definirTempoEntreChegadas(c1, new GeradorVariavelAleatoria(new Exponencial(100)));
        //fachada.definirTempoEntreChegadas(c2, new GeradorVariavelAleatoria(new Exponencial(120)));

         c1c1 = (float) fp.getProporcaoC1C1() / 100;
         c1c2 = (float) fp.getProporcaoC1C2() / 100;
         c1FA = (float) fp.getProporcaoC1FA() / 100;

         c2c2 = (float) fp.getProporcaoC2C2() / 100;
         c2c1 = (float) fp.getProporcaoC2C1() / 100;
         c2FA = (float) fp.getProporcaoC2FA() / 100;
          fachada.definirTemposChamada(c1, c1c1, c1c2, c1FA, new GeradorVariavelAleatoria(jp.getDistriuicaoChamadasC1()));
         fachada.definirTemposChamada(c2, c2c2, c2c1, c2FA, new GeradorVariavelAleatoria(jp.getDistriuicaoChamadasC2()));
        //fachada.definirTemposChamada(c1, 0.5f, 0.4f, 0.1f, new GeradorVariavelAleatoria(new Uniforme(180, 450)));
        //fachada.definirTemposChamada(c2, 0.5f, 0.4f, 0.1f, new GeradorVariavelAleatoria(new Uniforme(180, 500)));

    }

}
