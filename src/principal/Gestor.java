/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import listas.ListaAuspiciantes;
import listas.ListaParticipantesOrdenada;
import listas.ListaParticipantes;

/**
 *
 * @author carri
 */
public class Gestor {

    private ListaParticipantes listaParticipantes;
    private ListaParticipantesOrdenada listaParticipantesOrdenada;
    private ListaAuspiciantes listaAuspiciantes;
    private boolean inicioMaraton, finalMaraton;

    private static Gestor instancia = null;

    private static final int EDAD_A = 1, EDAD_B = 18, EDAD_C = 35;

    private Gestor() {
        this.listaParticipantes = new ListaParticipantes();
        this.listaParticipantesOrdenada = new ListaParticipantesOrdenada();
        this.listaAuspiciantes = new ListaAuspiciantes();
        this.inicioMaraton = false;
        this.finalMaraton = false;

    }

    public static Gestor get_() {
        if (instancia == null) {
            instancia = new Gestor();
        }
        return instancia;
    }

    public void imprimirCabecera() {
        System.out.println("---------------------------------------------------"
                + "------------------------------------------------------------"
                + "-------");
        System.out.printf("%10s %20s %20s %30s %4s %4s %9s %6s",
                "CEDULA", "NOMBRE", "APELLIDO", "AUSPICIANTES",
                "EDAD", "SEXO", "CATEGORIA", "HORA");
        System.out.println("---------------------------------------------------"
                + "------------------------------------------------------------"
                + "------");
    }

//------------------------ESTADO DEL MARATON----------------------------------
    public void iniciarMaraton() {
        inicioMaraton = true;
    }

    public void finalizarMaraton() {
        finalMaraton = true;
    }

    public String estadoMaraton() {
        if (!inicioMaraton && !finalMaraton) {
            return "No inicia";
        } else if (inicioMaraton && !finalMaraton) {
            return "Inicio";
        } else if (inicioMaraton && finalMaraton) {
            return "Termino";
        }
        return "Nada";
    }

//----------------------------AUSPICIANTES-----------------------------------
    public void guardarAuspiciantes(String auspiciantes) {
        if (auspiciantes.contains(",")) {
            String[] split = auspiciantes.split(",");
            for (String auspiciante : split) {
                if (!auspiciante.equals(" ")
                        && !listaAuspiciantes.existeAuspiciante(auspiciante)) {
                    listaAuspiciantes.insertar(auspiciante);
                }
            }
        } else {
            if (!listaAuspiciantes.existeAuspiciante(auspiciantes)) {
                listaAuspiciantes.insertar(auspiciantes);
            }
        }

    }

    public void imprimirAuspiciantes() {
        listaAuspiciantes.imprimir();
    }
    
    public int cantidadDeAuspiciantes(){ 
        return listaAuspiciantes.length();
    }

//----------------------------------PARTICIPANTES-------------------------------

    //CRUD
    public boolean inscribirParticipante(Participante p) {
        int edadParticipante = p.getEdad();
        if ((edadParticipante >= EDAD_A)&& (edadParticipante < EDAD_B)){
            listaParticipantes.inscribir(p, 'A');
            return true;
        } else if ((edadParticipante >= EDAD_B) && (edadParticipante < EDAD_C)){
            listaParticipantes.inscribir(p, 'B');
            return true;
        } else if (edadParticipante >= EDAD_C) {
            listaParticipantes.inscribir(p, 'C');
            return true;
        }
        return false;
    }

    public boolean borrarParticipante(String cedula) {
        return listaParticipantes.borrar(cedula);

    }
    public void imprimirParticipante(Participante p) {
        imprimirCabecera();
        listaParticipantes.imprimirParticipante(p);
    }

    public boolean registrarHoraLlegada(String cedula, int hora) {
        Participante p = getParticipante(cedula);
        if (p != null) {
            listaParticipantes.borrar(cedula);
            int edadParticipante = p.getEdad();
            if ((edadParticipante >= EDAD_A)&& (edadParticipante < EDAD_B)){
                listaParticipantesOrdenada.registrar(p, hora, 'A');
            } else if ((edadParticipante >= EDAD_B) && (edadParticipante < EDAD_C)){
                listaParticipantesOrdenada.registrar(p, hora, 'B');
            } else if (edadParticipante >= EDAD_C) {
                listaParticipantesOrdenada.registrar(p, hora, 'C');
            }
            return true;
        }
        return false;
    }
    
    public boolean existeParticipante(String cedula) {
        return (listaParticipantes.getParticipante(cedula) != null);
    }

    public boolean noParticipo(String cedula) {
        return listaParticipantes.noParticipo(cedula);
    }
    
    public Participante getParticipante(String cedula) {
        return listaParticipantes.getParticipante(cedula);
    }

//-------------------------------REPORTES---------------------------------------
    public void reportePorAuspiciante(int pos) {
        imprimirCabecera();
        String auspiciante = listaAuspiciantes.getAuspicianteXPosicion(pos - 1);
        listaParticipantesOrdenada.imprimirPorAuspiciante(auspiciante);
    }

    public void reportePorCategoria(int op) {
        imprimirCabecera();
        switch (op) {
            case 1:
                listaParticipantesOrdenada.imprimirPorCategoria('A');
                break;
            case 2:
                listaParticipantesOrdenada.imprimirPorCategoria('B');
                break;
            case 3:
                listaParticipantesOrdenada.imprimirPorCategoria('C');
                break;
        }
    }

    public void reporteNoParticipes() {
        imprimirCabecera();
        listaParticipantes.imprimirNoParticipes();
    }

    public void reporteNoCompletaron() {
        imprimirCabecera();
        listaParticipantes.imprimirNoCompletaron();
    }

}
