/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author carri
 */
//Clase participantes que almacena todo lo que pide el ejercicio
//Ademas de sus metodos para poder manejarlos
public class Participante {

    private String cedula, nombre, apellido, auspiciantes;
    private int edad;
    private char sexo;

    public Participante(String cedula, String nombre, String apellido,
            String auspiciantes, int edad, char sexo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.auspiciantes = auspiciantes;
        this.edad = edad;
        this.sexo = sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAuspiciantes(String auspiciantes) {
        this.auspiciantes = auspiciantes;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return this.edad;
    }

    public void imprimir(char categoria, String hora) {
        
        System.out.format("%10s %20s %20s %30s %4s %4s %9s %8s \n", this.cedula, this.nombre, this.apellido, this.auspiciantes, this.edad, this.sexo, categoria, hora);
    }

    public String getCedula() {
        return this.cedula;
    }

    public String getAuspiciantes() {
        return this.auspiciantes;
    }
}
