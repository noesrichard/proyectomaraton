/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradad_de_datos;

import entradad_de_datos.Entrada.CAMPOS;
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

    public static String ingresarDato(CAMPOS campo) {
        String dato;
        while (true) {
            System.out.print(campo.getPeticion());
            dato = Consola.get_().entrada.nextLine().toUpperCase();
            if (dato.matches(campo.getRegex())) {
                return dato;
            }
            System.out.println(campo.getError());
        }
    }

    public static String ingresarDatoConSalida(CAMPOS campo) {
        String dato;
        while (true) {
            System.out.print(campo.getPeticion());
            dato = Consola.get_().entrada.nextLine().toUpperCase();
            if (campo.getValidador().validar(dato) || dato.equals("-1")) {
                return dato;
            }
            System.out.println(campo.getError());
        }
    }

}
