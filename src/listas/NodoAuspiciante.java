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

    String auspiciante;
    NodoAuspiciante siguiente;

    NodoAuspiciante(String auspiciante) {
        this.auspiciante = auspiciante;
        this.siguiente = null;
    }
}
