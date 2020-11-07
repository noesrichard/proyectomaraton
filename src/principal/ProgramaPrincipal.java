/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import interfaz.Menus;

/**
 *
 * @author carri
 */
public class ProgramaPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //pruebas();
     
        boolean salir;
        do {
            salir = Menus.menuPrincipal();
        } while (salir == false);

    }

    

    private static void pruebas() {

        Gestor g = Gestor.get_();
        String aus = "Nike,Adidas,Puma";
        g.guardarAuspiciantes(aus);
        g.inscribirParticipante(new Participante("123", "Richard", "Carrion", "Nike,Adidas", 16, 'M'));
        g.inscribirParticipante(new Participante("456", "Manuel", "Valarezo", "Nike", 16, 'M'));
        g.inscribirParticipante(new Participante("789", "Jessica", "Tituaña", "Puma", 17, 'F'));
        g.inscribirParticipante(new Participante("1234", "Carlos", "Llamuca", "Nike", 15, 'M'));
        g.inscribirParticipante(new Participante("159", "Adriana", "Valarezo", "Nike", 14, 'F'));

        g.registrarHoraLlegada("123", 105020);
        g.registrarHoraLlegada("456", 92003);
        g.registrarHoraLlegada("789", 2023);
        //g.registrarHoraLlegada("1234",223);
        g.registrarHoraLlegada("159", 23);

        g.noParticipo("1234");

    }

}
