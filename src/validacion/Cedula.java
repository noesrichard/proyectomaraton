/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacion;

import principal.Gestor;

/**
 *
 * @author carri
 */
public class Cedula implements Validador {

    public static final int CEDULA_NUEVA = 1, CEDULA_EXISTENTE = 2;
    private String regex;
    private int opcion;

    public Cedula(int opcion) {
        this.opcion = opcion;
        this.regex = "[0-9]+";
    }

    @Override
    public boolean validar(String dato) {
        Gestor g = Gestor.get_();

        switch (this.opcion) {
            case CEDULA_NUEVA:
                if (validarCedula(dato)) {
                    //Si existe un participante con esa cedula retorna 
                    //falso ya que quiero ingresar una nueva cedula.
                    return !g.existeParticipante(dato);
                }
                return false;
            case CEDULA_EXISTENTE:
                if (validarCedula(dato)) {
                    //Si existe un participante con esa cedula retorna verdadero
                    //ya que quiero validar que esa cedula existe.
                    return g.existeParticipante(dato);
                }
                return false;

        }
        return false;
    }

    public static boolean validarCedula(String dato) {
        int indiceNumeros = 0;
        int auxSeparador = 1, multiplicador = 2, acumulador = 0, multiplicacion, ultimoDigito;
        if (dato.length() == 10) {
            while (indiceNumeros < 9) {
                if (multiplicador == 2) {
                    multiplicacion = 2 * Integer.parseInt(dato.substring(indiceNumeros, auxSeparador));
                    if (multiplicacion >= 10) {
                        acumulador = acumulador + multiplicacion - 9;
                    } else {
                        acumulador = acumulador + multiplicacion;
                    }
                    multiplicador = 1;
                } else {
                    acumulador = acumulador + (Integer.parseInt(dato.substring(indiceNumeros, auxSeparador)));
                    multiplicador = 2;
                }
                indiceNumeros++;
                auxSeparador++;
            }
            ultimoDigito = Integer.parseInt(dato.substring(9, 10));
            return (acumulador + ultimoDigito) % 10 == 0;
        } else {
            return false;
        }
    }
}
