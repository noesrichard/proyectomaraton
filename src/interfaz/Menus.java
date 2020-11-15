/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import entradad_de_datos.Entrada;
import entradad_de_datos.Formularios;
import principal.Gestor;
import principal.Participante;

/**
 *
 * @author carri
 */
public class Menus {
    //Aqui van los menus. Osea puros prints y switch. 

    static Gestor g = Gestor.get_();
//---------------------------------[0]MENU PRINCIPAL-------------------------------------
    public static boolean menuPrincipal() {
        int opcion = Formularios.menuPrincipal();
        switch (opcion) {
            case 1:
                opcionUno();
                break;
            case 2:
                opcionDos();
                break;
            case 3:
                opcionTres();
                break;
            case 0:
                return true;
        }
        return false;
    }

    private static void opcionUno() {
        switch (g.estadoMaraton()) {
            case "No inicia":
                //[1]MENU PARTICIPANTES
                menuParticipantes();
                break;
            case "Inicio":
                Formularios.registrarHoraLlegada();
                break;
            case "Termino":
                //[2]MENU REPORTES
                menuReportes();
                break;
            default:
                break;
        }
    }

//---------------------------------[1]MENU PARTICIPANTES-------------------------------------
    private static void menuParticipantes() {
        boolean volver = false;
        do {
            int opcion = Formularios.menuParticipante();
            switch (opcion) {
                case 1:
                    Formularios.inscribirParticipante();
                    break;
                case 2:
                    Formularios.visualizarParticipante();
                    break;
                case 3:
                    //[1.1]MENU ACTUALIZAR PARTICIPANTE
                    menuActualizarParticipante();
                    break;
                case 4:
                    Formularios.borrarParticipante();
                    break;
                case 5:
                    volver = true;
                    break;
            }
        } while (volver == false);
    }
//---------------------------------[1.1]MENU ACTUALIZAR PARTICIPANTE-------------------------------------

    private static void menuActualizarParticipante() {
        boolean volver = false;
        Participante p = Formularios.getParticipante();
        g.imprimirParticipante(p);
        do {            
            if (p != null) {
                int opcion = Formularios.menuActualizarParticipante();
                switch (opcion) {
                    case 1:
                        Formularios.actualizarNombre(p);
                    case 2:
                        Formularios.actualizarApellido(p);
                    case 3:
                        Formularios.actualizarAuspiciantes(p);
                    case 4:
                        Formularios.actualizarEdad(p);
                    case 5:
                        Formularios.actualizarSexo(p);
                    case 6:
                        volver = true;
                        break;
                }
            } else {
                volver = true;
            }
        } while (volver == false);
    }
//---------------------------------[2]MENU REPORTES-------------------------------------

    private static void menuReportes() {
        boolean volver = false;
        do {
            int opcion = Formularios.menuReportes();
            switch (opcion) {
                case 1:
                    reportesPorAuspiciante();
                    break;
                case 2:
                    reportesPorCategoria();
                    break;
                case 3:
                    g.reporteNoParticipes();
                    break;
                case 4:
                    g.reporteNoCompletaron();
                    break;
                case 5:
                    volver = true;
                    break;
            }
        } while (volver == false);
    }

    private static void reportesPorAuspiciante() {
        int numOpciones = g.cantidadDeAuspiciantes();
        if (numOpciones > 0) {
            int opcion = Formularios.reportePorAuspiciante(numOpciones);
            g.reportePorAuspiciante(opcion);
        } else {
            System.out.println(Mensajes.NOTIF.LISTA_VACIA.txt());
        }

    }

    private static void reportesPorCategoria() {
        int opcion = Formularios.reportePorCategoria();
        g.reportePorCategoria(opcion);
    }

    
    private static void opcionDos() {
        switch (g.estadoMaraton()) {
            case "No inicia":
                g.iniciarMaraton();
                break;
            case "Inicio":
                Formularios.registrarNoParticipe();
                break;
            default:
                break;
        }
    }

    private static void opcionTres() {
        if (g.estadoMaraton().equals("Inicio")) {
            g.finalizarMaraton();
        }
    }
}
