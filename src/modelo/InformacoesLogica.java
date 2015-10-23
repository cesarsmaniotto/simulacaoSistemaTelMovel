/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.evento.Evento;
import modelo.evento.EventoFimChamada;
import modelo.evento.EventoFimSimulacao;
import modelo.evento.EventoInicioChamada;
import modelo.evento.EventoInicioSimulacao;
import modelo.evento.EventoMudancaCanal;
import modelo.evento.EventoSaidaAreaCobertura;


/**
 *
 * @author rr
 * nao consegui pensar num nome melhor para essa bagaça
 * mas o objetivo é dado uma instancia de estado e evento, extrair as informacoes necessarias para exibir na tabela
 * é possível notificar o estado e evento, mas isso seria incorreto. De modo que a interface teria acesso aos objetos da logica
 */
public class InformacoesLogica {
    String infosEvento;
    String[] infosEstado = new String[3];
    public InformacoesLogica(){
        /*infosEstado = new String[3];
        infosEvento = new String[2];*/
        
        
    }
    public void defineInformacoes(Evento evento, Estado estado){
        
        /*if((evento instanceof EventoInicioChamada)){
            this.infosEvento = ((EventoInicioChamada) evento).toString();
            
        }
        if(evento instanceof EventoFimSimulacao){
            this.infosEvento = evento.toString();
         
        }
        if(evento instanceof EventoFimChamada || (evento instanceof EventoMudancaCanal) || (evento instanceof EventoSaidaAreaCobertura)){
            this.infosEvento = evento.toString();
        }
        if(evento instanceof EventoInicioSimulacao){
            this.infosEvento = "INICIO";
        }*/
        infosEvento = evento.toString();
        infosEstado[0] = Integer.toString(estado.getOcupacaoCanal("C1"));
        infosEstado[1] = Integer.toString(estado.getOcupacaoCanal("C2"));
        infosEstado[2] = estado.getTempoInicio().toString();
        
        
        
    }
    public String getInfoEvento(){
        return infosEvento;
    }
    public String[] getInfoEstado(){
        return infosEstado;
    }
    
    
    
}
