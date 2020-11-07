/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradad_de_datos;

import java.util.Scanner;
import validacion.Validador;

/**
 *
 * @author carri
 */
public class Consola {

    private static Consola instancia = null;
    public Scanner entrada;

    private Consola() {
        entrada = new Scanner(System.in);
    }

    public static Consola get_() {
        if (instancia == null) {
            instancia = new Consola();
        }

        return instancia;
    }

    public static String ingresarDato(String mensajeEntrada, String mensajeError, String regex) {
        String dato;
        while (true) {
            System.out.print(mensajeEntrada);
            dato = Consola.get_().entrada.nextLine().toUpperCase();
            if (dato.matches(regex)) {
                return dato;
            }
            System.out.println(mensajeError);
        }
    }

    public static String ingresarDato(String mensajeEntrada, String mensajeError, Validador validador) {
        String dato;
        while (true) {
            System.out.print(mensajeEntrada);
            dato = Consola.get_().entrada.nextLine().toUpperCase();
            if (validador.validar(dato) || dato.equals("-1")) {
                return dato;
            }
            System.out.println(mensajeError);
        }
    }

}
