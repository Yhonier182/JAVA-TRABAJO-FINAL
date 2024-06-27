/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import CONTROLADOR.controladorAlquiler;
import Vistas.vistaAlquiler;
import Vistas.vistaArrendatarios;
import Vistas.vistaPropiedades;
import lOGICAMODELO.logicaAlquiler;

/**
 * @author JHONIER ARIAS
 */
public class main {
    public static vistaArrendatarios  arren;
    public static vistaPropiedades  pro;
    public static vistaAlquiler vistaAlquiler;
//    public static tablas tablas;
    public static controladorAlquiler contAlquier;


    public static void main(String[] args) {

        arren= new vistaArrendatarios();
        pro = new vistaPropiedades();
        vistaAlquiler = new vistaAlquiler();


        vistaAlquiler.setVisible(true);
        vistaAlquiler.setLocationRelativeTo(null);

        contAlquier = new controladorAlquiler(arren,pro,vistaAlquiler);
        logicaAlquiler x = new logicaAlquiler();
        x.mostrarAlquiler(vistaAlquiler.tablaAlquiler);

}
}
