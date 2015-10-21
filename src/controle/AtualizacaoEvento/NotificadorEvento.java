/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.AtualizacaoEvento;

import controle.ProgressoSimulacao;
import java.util.Observable;
import java.util.Observer;
import modelo.Estado;
import modelo.InformacoesLogica;
import modelo.evento.Evento;


/**
 *
 * @author rr
 */
public class NotificadorEvento extends Observable{

    public NotificadorEvento(Observer o) {
        addObserver(o);
    }

    public NotificadorEvento() {
        
    }
    
    public void notificarEstado(Estado e){
        notifyObservers(e);
        setChanged();
    }
    public void notificarEvento(Evento e){
        notifyObservers(e);
        setChanged();
        
    }
    public void notificarProgresso(ProgressoSimulacao ps){
        notifyObservers(ps);
        setChanged();
        
    }

    

    public void notificarInformacoes(InformacoesLogica il) {
        notifyObservers(il);
        setChanged();
        
    }
    
    
    
}
