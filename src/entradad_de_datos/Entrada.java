/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradad_de_datos;

import interfaz.Mensajes;
import validacion.Cedula;
import validacion.Validador;

/**
 *
 * @author carri
 */
public class Entrada {

    private enum REGEX {
        SOLO_LETRAS("[a-zA-Z]+"),
        TODO(".{0,}"),
        SEXO("M|F"),
        NUMERO_ENTERO("[0-9]+"),
        HORAS("[0-9]{2}"),
        MIN_SEG("[0-5][0-9]"),
        OPCION_MENU("[0-%d]");

        private String valor;

        private REGEX(String v) {
            valor = v;
        }

        public String txt() {
            return valor;
        }
        
        
    }

    public enum CAMPOS{
        OPCION("Opcion: ","Numero de opcion no valido","[0-6]"),
        NOMBRE("INGRESE EL NOMBRE: ","NOMBRE NO VALIDO",REGEX.SOLO_LETRAS.txt()),
        APELLIDO("INGRESE EL APELLIDO: ","APELLIDO NO VALIDO",REGEX.SOLO_LETRAS.txt()),
        EDAD("INGRESE LA EDAD: ","EDAD NO VALIDA",REGEX.NUMERO_ENTERO.txt()),
        SEXO("INGRESE EL SEXO (M/F): ","SEXO NO VALIDO",REGEX.SEXO.txt()),
        HORAS("HORAS (HH): ","FORMATO NO VALIDO",REGEX.NUMERO_ENTERO.txt()),
        MINUTOS("MINUTOS (MM): ","FORMATO NO VALIDO", REGEX.MIN_SEG.txt()),
        SEGUNDOS("SEGUNDOS (SS): ","FORMATO NO VALIDO",REGEX.MIN_SEG.txt()),
        CEDULA_NUEVA("INGRESE EL NUMERO DE CEDULA: ","NUMERO DE CEDULA NO VALIDO",
                new Cedula(Cedula.CEDULA_NUEVA)),
        CEDULA_EXISTENTE("INGRESE EL NUMERO DE CEDULA: ","NUMERO DE CEDULA NO VALIDO",
                new Cedula(Cedula.CEDULA_EXISTENTE));
        
        private String peticion;
        private Validador validador; 
        private String error;
        private String regex;
        
        private CAMPOS(String peticion,String error,String regex){ 
            this.peticion = peticion;
            this.error = error; 
            this.regex = regex; 
        }
        private CAMPOS(String peticion,String error,Validador validador){ 
            this.peticion = peticion;
            this.error =  error; 
            this.validador = validador; 
        }
        
        public String getPeticion(){ 
            return this.peticion;
        }
        
        public String getError(){ 
            return this.error;
        }
        
        public String getRegex(){ 
            return this.regex;
        }
        
        public Validador getValidador(){ 
            return this.validador;
        }
        
    }
    
}
