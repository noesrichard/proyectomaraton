/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradad_de_datos;

import interfaz.Mensajes;
import principal.Gestor;
import principal.Participante;

/**
 *
 * @author carri
 */
public class Formularios {

    private static Gestor g = Gestor.get_();

    public static int imprimirMenu(Mensajes.MENUS [] menu) {
        int numOpciones = 0;
        for (Mensajes.MENUS mensaje : menu) {
            System.out.println(mensaje.txt());
            numOpciones++;
        }
        return numOpciones;
    }
    
//--------------------------------------MENUS--------------------------------------------
    public static int menuPrincipal() {
        int numOpciones = 0;
        System.out.println("\n");
        System.out.println(Mensajes.MENU_PRINCIPAL.ENCABEZADO_MENU.txt());
        switch (g.estadoMaraton()) {
            case "No inicia":
                System.out.println(Mensajes.MENU_PRINCIPAL.PARTI.txt());
                System.out.println(Mensajes.MENU_PRINCIPAL.SALIDA.txt());
                numOpciones = 2;
                break;
            case "Inicio":
                System.out.println(Mensajes.MENU_PRINCIPAL.REGIS_HORA.txt());
                System.out.println(Mensajes.MENU_PRINCIPAL.REGIS_NO_PARTI.txt());
                System.out.println(Mensajes.MENU_PRINCIPAL.FINALIZAR.txt());
                numOpciones = 3;
                break;
            case "Termino":
                System.out.println(Mensajes.MENU_PRINCIPAL.VER_REPORTES.txt());
                numOpciones = 1;
                break;
        }
        System.out.println(Mensajes.MENU_PRINCIPAL.SALIR.txt());
        return Campos.campoDeMenu(numOpciones);
    }

    public static int menuParticipante() {
        int numOpciones = imprimirMenu(Mensajes.MENU_PARTICIPANTE.values());
        return Campos.campoDeMenu(numOpciones);
    }

    public static int menuActualizarParticipante() {
        int numOpciones = imprimirMenu(Mensajes.MENU_ACTUALIZAR.values());
        return Campos.campoDeMenu(numOpciones);
    }

    public static int menuReportes() {
        int numOpciones = imprimirMenu(Mensajes.MENU_REPORTES.values());
        return Campos.campoDeMenu(numOpciones);
    }
//----------------------------FORMULARIOS PARA DATOS----------------------------
    public static boolean inscribirParticipante() {
        String cedula = Campos.campoDeCedula(Campos.CEDULA_NUEVA);
        if (!cedula.equals("-1")) {
            String  nombre = Campos.campoDeTexto(Campos.NOMBRE);
            String  apellido = Campos.campoDeTexto(Campos.APELLIDO);
            int     edad = Campos.campoDeNumeros(Campos.EDAD);
            char    sexo = Campos.campoDeTexto(Campos.SEXO).charAt(0);
            String  auspiciantes = Campos.campoDeTexto(Campos.AUSPICIANTES);
            g.guardarAuspiciantes(auspiciantes);
            Participante p = new Participante(cedula, nombre, apellido, 
                                            auspiciantes,edad, sexo);
            if (!g.inscribirParticipante(p)) {
                System.out.println(Mensajes.ERROR.REGISTRAR.txt());
            }
        }
        return true;
    }

    public static boolean visualizarParticipante() {
        String cedula = Campos.campoDeCedula(Campos.CEDULA_EXISTENTE);
        Participante p = g.getParticipante(cedula);
        if (p != null) {
            g.imprimirParticipante(p);
        } else {
            System.out.println(Mensajes.NOTIF.PARTICIPANTE_NO_EXISTE.txt());
        }
        return true;
    }

    public static Participante getParticipante() {
        String cedula = Campos.campoDeCedula(Campos.CEDULA_EXISTENTE);
        if (!cedula.equals("-1")) {
            return g.getParticipante(cedula);
        }
        return null;
    }

    public static boolean borrarParticipante() {
        String cedula = Campos.campoDeCedula(Campos.CEDULA_EXISTENTE);
        if (g.borrarParticipante(cedula)) {
            System.out.println(Mensajes.NOTIF.BORRADO_EXITO.txt());
        } else {
            System.out.println(Mensajes.NOTIF.PARTICIPANTE_NO_EXISTE.txt());
        }

        return true;
    }

    public static boolean registrarHoraLlegada() {
        int id  = Campos.campoDeNumeros(Campos.EDAD);
        if (id != -1) {
            String  hora = Campos.campoDeTiempo(Campos.HORA);
            String  min = Campos.campoDeTiempo(Campos.MIN);
            String  seg = Campos.campoDeTiempo(Campos.SEG);
            int     tiempo = Integer.parseInt(hora + min + seg);
            if (g.registrarHoraLlegada(id, tiempo)) {
                System.out.println(Mensajes.NOTIF.TIEMPO.txt());
                return true;
            }
        }
        return false;
    }

    public static boolean registrarNoParticipe() {
        String cedula = Campos.campoDeCedula(Campos.CEDULA_EXISTENTE);
        if (g.noParticipo(cedula)) {
            System.out.println(Mensajes.NOTIF.TIEMPO.txt());
            return true;
        }
        return false;
    }

    public static int reportePorAuspiciante(int numOpciones) {
        g.imprimirAuspiciantes();
        return Campos.campoDeMenu(numOpciones);
    }

    public static int reportePorCategoria() {
        imprimirMenu(Mensajes.MENU_CATEGORIAS.values());
        return Campos.campoDeMenu(3);
    }

}
