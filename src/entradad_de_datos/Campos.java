/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradad_de_datos;

import interfaz.Mensajes;
import validacion.Cedula;

/**
 *
 * @author carri
 */
public class Campos {

    public static final int NOMBRE = 1, APELLIDO = 2, AUSPICIANTES = 3,
                            SEXO = 4, EDAD = 1, HORA = 1, MIN = 2, SEG = 3,
                            CEDULA_NUEVA = 1, CEDULA_EXISTENTE = 2;

    private enum REGEX {
        SOLO_LETRAS("[a-zA-Z]+"),
        TODO(".{0,}"),
        SEXO("M|F"),
        NUMERO_ENTERO("[0-9]+"),
        TIEMPO("[0-9]{2}");

        private String valor;

        private REGEX(String v) {
            valor = v;
        }

        public String txt() {
            return valor;
        }
    }

    public static String campoDeTexto(int opcion) {
        switch (opcion) {
            case NOMBRE:
                return Consola.ingresarDato(Mensajes.ENTRADA.NOMBRE.txt(),
                                            Mensajes.ERROR.NOMBRE.txt(),
                                            REGEX.SOLO_LETRAS.txt());
            case APELLIDO:
                return Consola.ingresarDato(Mensajes.ENTRADA.APELLIDO.txt(),
                                            Mensajes.ERROR.APELLIDO.txt(), 
                                            REGEX.SOLO_LETRAS.txt());
            case AUSPICIANTES:
                return Consola.ingresarDato(Mensajes.ENTRADA.AUSPICIANTES.txt(),
                                            Mensajes.ERROR.AUSPICIANTES.txt(),
                                            REGEX.TODO.txt());
            case SEXO:
                return Consola.ingresarDato(Mensajes.ENTRADA.SEXO.txt(),
                                            Mensajes.ERROR.SEXO.txt(),
                                            REGEX.SEXO.txt());
        }
        return null;
    }

    public static String campoDeTiempo(int opcion) {
        switch (opcion) {
            case HORA:
                return Consola.ingresarDato(Mensajes.ENTRADA.HORA.txt(),
                                            Mensajes.ERROR.TIEMPO.txt(),
                                            REGEX.TIEMPO.txt());    
            case MIN:
                return Consola.ingresarDato(Mensajes.ENTRADA.MINUTOS.txt(),
                                            Mensajes.ERROR.TIEMPO.txt(),
                                            REGEX.TIEMPO.txt());
            case SEG:
                return Consola.ingresarDato(Mensajes.ENTRADA.SEGUNDOS.txt(),
                                            Mensajes.ERROR.TIEMPO.txt(),
                                            REGEX.TIEMPO.txt());
        }
        return "";
    }

    public static int campoDeMenu(int numOpciones) {
        String regexMenu = String.format("[0-%d]", numOpciones);
        return Integer.parseInt(Consola.ingresarDato(
                                Mensajes.ENTRADA.OPCION.txt(),
                                Mensajes.ERROR.OPCION.txt(),
                                regexMenu)
                                );
    }

    public static int campoDeNumeros(int opcion) {
        switch (opcion) {
            case EDAD:
                return Integer.parseInt(Consola.ingresarDato(
                                        Mensajes.ENTRADA.EDAD.txt(),
                                        Mensajes.ERROR.EDAD.txt(),
                                        REGEX.NUMERO_ENTERO.txt())
                                        );
        }
        return -1;
    }

    public static String campoDeCedula(int opcion) {
        switch (opcion) {
            case CEDULA_NUEVA:
                return Consola.ingresarDato(Mensajes.ENTRADA.CEDULA.txt(),
                                            Mensajes.ERROR.CEDULA.txt(), 
                                            new Cedula(Cedula.CEDULA_NUEVA));
            case CEDULA_EXISTENTE:
                return Consola.ingresarDato(Mensajes.ENTRADA.CEDULA.txt(),
                                            Mensajes.ERROR.CEDULA.txt(), 
                                            new Cedula(Cedula.CEDULA_EXISTENTE));
        }
        return "";
    }
}
