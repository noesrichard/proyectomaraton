/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author carri
 */
public class NodoAuspiciante {

    private String auspiciante;
    private NodoAuspiciante siguiente;

    NodoAuspiciante(String auspiciante) {
        this.auspiciante = auspiciante;
        this.siguiente = null;
    }
    
    public NodoAuspiciante getSiguiente(){ 
        return this.siguiente; 
    }
    
    public void setSiguiente(NodoAuspiciante siguiente){ 
        this.siguiente = siguiente; 
    }
    
    public String getAuspiciante(){ 
        return this.auspiciante; 
    }
   
}
