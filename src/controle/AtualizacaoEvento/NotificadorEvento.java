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
    
    public void notificarEvento(Estado e){
        notifyObservers(e);
        setChanged();
    }
    public void notificarProgresso(ProgressoSimulacao ps){
        notifyObservers(ps);
        setChanged();
        
    }
    
    
    
}
