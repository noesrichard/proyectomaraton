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
public class ListaAuspiciantes {
    NodoAuspiciante primero; 
    
    public ListaAuspiciantes(){ 
        this.primero = null;
    }
    
    public boolean insertar( String auspiciante ){ 
        NodoAuspiciante nuevo; 
        try{ 
          nuevo  = new NodoAuspiciante( auspiciante ); 
        }catch( Exception e ){ 
            return false;
        }
        if ( this.primero == null )
            this.primero = nuevo; 
        else{
            NodoAuspiciante aux = this.primero; 
            while ( aux.siguiente != null ){ 
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;  
        }
        return true; 
    }
    
    public void imprimir(){ 
       NodoAuspiciante aux = this.primero; 
       int i = 1; 
       while ( aux != null ){ 
           System.out.println("["+i+"]"+aux.auspiciante);
           aux = aux.siguiente;
           i++;
       }
    }
    
    public int length(){ 
        NodoAuspiciante aux = this.primero;
        int cantidad = 0;
        if ( aux == null ) 
            return 0; 
        while ( aux != null ){
            cantidad++;
            aux = aux.siguiente; 
        }
        return cantidad; 
    }
    
    public String getAuspiciantePorPosicion(int pos){ 
        int posActual = 0; 
        NodoAuspiciante aux = this.primero; 
        while ( posActual < pos  ){ 
            aux = aux.siguiente; 
            posActual++;
        }
        return aux.auspiciante;
    }
    public boolean existeAuspiciante(String auspiciante ){ 
        NodoAuspiciante aux = this.primero; 
        if ( aux == null )
            return false; 
        while ( aux != null ){ 
            if ( aux.auspiciante.equals(auspiciante) ){ 
                return true; 
            }
            aux = aux.siguiente; 
        }
        return false; 
    }
}
