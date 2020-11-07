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
//Lista doblemente enlazada de Inscritos
public class ListaParticipantes {

    NodoParticipantes primero;

    public ListaParticipantes() {
        this.primero = null;
    }

    public boolean inscribir(Participante dato, char categoria) {
        NodoParticipantes nuevo;
        try {
            nuevo = new NodoParticipantes(dato, categoria);
        } catch (Exception e) {
            return false;
        }
        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            NodoParticipantes aux = this.primero;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
            nuevo.anterior = aux;

        }
        return true;
    }

    public boolean borrar(String cedula) {
        NodoParticipantes aux = this.primero;
        if (aux.participante.getCedula().equals(cedula)) {
            this.primero = aux.siguiente;
            return true;
        }
        while (aux.siguiente != null) {
            if (aux.participante.getCedula().equals(cedula)) {

                aux.anterior.siguiente = aux.siguiente;
                aux.siguiente.anterior = aux.anterior;

                aux.anterior = null;
                aux.siguiente = null;
                return true;
            }

            aux = aux.siguiente;
        }
        if (aux.siguiente == null && aux.participante.getCedula().equals(cedula)){
            aux.anterior.siguiente = null;
            aux.anterior = null;
            return true;
        }
        return false;
    }

    public boolean noParticipo(String cedula) {
        NodoParticipantes aux = this.primero;
        while (aux != null) {
            if (aux.participante.getCedula().equals(cedula)) {
                aux.participoPregunta = false;
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    public void imprimir() {
        NodoParticipantes aux = this.primero;
        while (aux != null) {
            aux.participante.imprimir(aux.categoria,String.valueOf(aux.hora));
            aux = aux.siguiente;
        }
    }

    public void imprimirNoParticipes() {
        NodoParticipantes aux = this.primero;
        while (aux != null) {
            if (!aux.participoPregunta) {
                aux.participante.imprimir(aux.categoria,String.valueOf(aux.hora));
            }
            aux = aux.siguiente;
        }
    }

    public void imprimirNoCompletaron() {
        NodoParticipantes aux = this.primero;
        while (aux != null) {
            if (aux.hora == -1 && aux.participoPregunta) {
                aux.participante.imprimir(aux.categoria,String.valueOf(aux.hora));
            }
            aux = aux.siguiente;
        }
    }

    public void imprimirParticipante(Participante p) {
        NodoParticipantes aux = this.primero;
        while (aux != null) {
            if (aux.participante == p) {
                aux.participante.imprimir(aux.categoria,String.valueOf(aux.hora));
            }
            aux = aux.siguiente;
        }
    }

    public Participante getParticipante(String cedula) {
        NodoParticipantes aux = this.primero;
        while (aux != null) {
            if (aux.participante.getCedula().equals(cedula)) {
                return aux.participante;
            }
            aux = aux.siguiente;
        }
        return null;
    }
}
