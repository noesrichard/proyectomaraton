/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import interfaz.Mensajes;
import principal.Participante;

/**
 *
 * @author carri
 */
//lista doblemente enlazada de aquellos que si completaron la carrera
public class ListaParticipantesOrdenada {

    NodoParticipantes primero;
    

    public ListaParticipantesOrdenada() {
        this.primero = null;
    }

    public boolean registrar(Participante participante, int hora, char c, int id ) {
        NodoParticipantes nuevo;
        try {
            nuevo = new NodoParticipantes(participante, hora, c, id);
        } catch (Exception e) {
            return false;
        }
        if (this.primero == null) {
            this.primero = nuevo;
        } else {
            NodoParticipantes aux = this.primero;
            if (nuevo.hora < this.primero.hora) {
                this.primero.anterior = nuevo;
                this.primero = nuevo;
                this.primero.siguiente = aux;
            } else {
                while (aux != null) {
                    if (nuevo.hora < aux.hora) {
                        aux.anterior.siguiente = nuevo;
                        nuevo.anterior = aux.anterior;
                        aux.anterior = nuevo;
                        nuevo.siguiente = aux;
                        break;
                    } else if (aux.siguiente == null) {
                        aux.siguiente = nuevo;
                        nuevo.anterior = aux;
                        break;
                    }
                    aux = aux.siguiente;
                }
            }

        }
        return true;
    }

    public void imprimir() {
        NodoParticipantes aux = this.primero;
        while (aux != null) {
            aux.participante.imprimir(aux.id, aux.categoria,convertirHora(aux.hora));
            aux = aux.siguiente;
        }
    }

    public void imprimirPorCategoria(char categoria) {
        NodoParticipantes aux = this.primero;
        while (aux != null) {
            if (aux.categoria == categoria) {
                aux.participante.imprimir(aux.id, aux.categoria,convertirHora(aux.hora));
            }
            aux = aux.siguiente;
        }
    }

    public void imprimirPorAuspiciante(String auspiciante) {
        NodoParticipantes aux = this.primero;
        while (aux != null) {
            if (aux.participante.getAuspiciantes().contains(auspiciante)) {
                aux.participante.imprimir(aux.id, aux.categoria,convertirHora(aux.hora));
            }
            aux = aux.siguiente;
        }
    }

    private String convertirHora(int valor) {
        String tiempo = String.valueOf(valor);
        String[] digitos = tiempo.split("");
        int cantidadDigitos = digitos.length;
        String hora = "";
        int i = 0;
        for (String digito : digitos) {
            if (cantidadDigitos % 2 == 0) {
                if (i % 2 != 0 && i != cantidadDigitos - 1) {
                    hora += digito + ":";
                } else {
                    hora += digito;
                }
                i++;
            } else {
                if (i % 2 == 0 && i != cantidadDigitos - 1) {
                    hora += digito + ":";
                } else {
                    hora += digito;
                }
                i++;
            }
        }
        return hora;
    }

}
