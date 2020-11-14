/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import principal.Participante;

/**
 *
 * @author carri
 */
public class NodoParticipantes {
	Participante participante; 
	char categoria;
	int hora; 
        int id; 
	NodoParticipantes siguiente; 
	NodoParticipantes anterior;
	boolean participoPregunta;
	
	public NodoParticipantes(Participante participante, char categoria,int id ){ 
            this.participante = participante; 
            this.categoria = categoria; 
            this.hora = -1;
            this.siguiente = null; 
            this.anterior = null; 
            this.participoPregunta = true; 
            this.id = id; 
	}
        public NodoParticipantes( Participante participante, int hora, char c, int id ){ 
	    this.participante = participante; 
	    this.hora = hora; 
	    this.categoria = c; 
	    this.siguiente = null;
	    this.anterior = null; 
            this.participoPregunta = true;
            this.id = id; 
	}
	
        
}
