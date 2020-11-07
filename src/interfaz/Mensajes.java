package interfaz;

/**
 *
 * @author felix
 */
public class Mensajes {

    public enum ENTRADA {
        OPCION("Opción: "),
        CEDULA("INGRESE NUMERO DE CEDULA:  "),
        NOMBRE("INGRESE EL NOMBRE:  "),
        APELLIDO("INGRESE EL APELLIDO: "),
        EDAD("INGRESE LA EDAD: "),
        SEXO("INGRESE EL SEXO (M/F): "),
        AUSPICIANTES("INGRESE LOS AUSPICIANTES (Auspiciante1,Auspiciante2): "),
        HORA("HORAS (HH): "),
        MINUTOS("MINUTOS (MM): "),
        SEGUNDOS("SEGUNDOS (SS): ");

        private String valor;

        private ENTRADA(String v) {
            valor = v;
        }

        public String txt() {
            return valor;
        }
    }

    public enum ERROR {
        OPCION("Número de opción no válida."),
        CEDULA("Numero de cedula no valido. "),
        NOMBRE("Nombre no valido. "),
        APELLIDO("Apellido no valido."),
        EDAD("Edad no valida."),
        SEXO("Sexo no valido."),
        AUSPICIANTES("Auspiciantes no validos."),
        TIEMPO("FORMATO NO VALIDO!"),
        REGISTRAR("NO SE PUDO REGISTRAR LA INFORMACION CORRECTAMENTE");

        private String valor;

        private ERROR(String v) {
            valor = v;
        }

        public String txt() {
            return valor;
        }
    }

    public enum NOTIF {

        BORRADO_EXITO("SE BORRO AL PARTICIPANTE CON EXITO!"),
        PARTICIPANTE_NO_EXISTE("EL PARTICIPANTE CON DICHA CEDULA NO EXISTE"),
        TIEMPO("SE HA REGISTRADO EL TIEMPO DEL PARTICIPANTE CORRECTAMENTE"),
        BLOQUEADA("\t(Opcion bloqueada)"),
        LISTA_VACIA("No puede seleccionar nada debido a que la lista esta vacia!");

        private String valor;

        private NOTIF(String v) {
            valor = v;
        }

        public String txt() {
            return valor;
        }
    }

    public interface MENUS {
        public String txt();
    }

    public enum MENU_PRINCIPAL implements MENUS {
        ENCABEZADO_MENU("***********    MENU PRINCIPAL **********"),
        PARTI("[1] MENU PARTICIPANTES "),
        SALIDA("[2] DAR SALIDA AL MARATON "),
        REGIS_HORA("[1] REGISTAR LLEGADA PARTICIPANTE"),
        REGIS_NO_PARTI("[2] REGISTRAR INSCRITO QUE NO PARTICIPO"),
        FINALIZAR("[3] FINALIZAR MARATON "),
        VER_REPORTES("[1] VER REPORTES "),
        SALIR("[0] SALIR"),
        OPCION_BLOQUEADA("(Esta opcion esta bloqueada)");

        private String valor;

        private MENU_PRINCIPAL(String v) {
            valor = v;
        }

        @Override
        public String txt() {
            return valor;
        }
    }

    public static enum MENU_PARTICIPANTE implements MENUS {

        CABEZERA("******* MENU PARTICIPANTE ********"),
        CREAR("[1] CREAR PARTICIPANTE"),
        VISUALIZAR("[2] VISUALIZAR PARTICIPANTE"),
        ACTUALIZAR("[3] ACTUALIZAR PARTICIPANTE"),
        BORRAR("[4] BORRAR PARTICIPANTE"),
        VOLVER("[5] VOLVER");

        private String valor;

        private MENU_PARTICIPANTE(String v) {
            valor = v;
        }

        @Override
        public String txt() {
            return valor;
        }
    }

    public static enum MENU_ACTUALIZAR implements MENUS {
        CABEZERA("******MENU PARA ACTUALIZAR A UN PARTICIPANTE*******"),
        NOMBRE("[1] ACTULIZAR NOMBRE"),
        APELLIDO("[2] ACTUALIZAR APELLIDO"),
        AUSPICIANTES("[3] ACTUALIZAR AUSPICIANTES"),
        EDAD("[4] ACTUALIZAR EDAD"),
        SEXO("[5] ACTUALIZAR SEXO"),
        VOLVER("[6] VOLVER");

        private String valor;

        private MENU_ACTUALIZAR(String v) {
            valor = v;
        }

        @Override
        public String txt() {
            return valor;
        }
    }

    public static enum MENU_REPORTES implements MENUS {
        CABEZERA("******MENU PARA ACTUALIZAR A UN PARTICIPANTE*******"),
        OPCION_1("[1] PARTICIPANTES POR AUSPICIANTE"),
        OPCION_2("[2] PARTICIPANTES POR CATEGORIA EN ORDEN DE LLEGADA "),
        OPCION_3("[3] INSCRITOS QUE NO PARTICIPARON "),
        OPCION_4("[4] PARTICIPANTES QUE NO COMPLETARON LA CARRERA"),
        VOLVER("[5] VOLVER");

        private String valor;

        private MENU_REPORTES(String v) {
            valor = v;
        }

        @Override
        public String txt() {
            return valor;
        }

    }

    public enum MENU_CATEGORIAS implements MENUS {
        CABEZERA("*********CATEGORIAS************"),
        A("[1] CATEGORIA A"),
        B("[2] CATEGORIA B"),
        C("[3] CATEGORIA C"),
        VOLVER("[4] VOLVER");
        private String valor;

        private MENU_CATEGORIAS(String v) {
            valor = v;
        }

        @Override
        public String txt() {
            return valor;
        }
    }

}
