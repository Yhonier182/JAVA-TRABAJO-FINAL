/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heladeria;

import com.mycompany.heladeria.Vista.ForMenu;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import com.mycompany.heladeria.Vista.Empleado;
import com.mycompany.heladeria.Vista.Superior;


public class Main {
    
    public static void main(String[] args) {
    
        /*ForMenu form = new ForMenu();
        form.setVisible(true);
        form.setDefaultCloseOperation(EXIT_ON_CLOSE);*/
        
       /* Empleado empleadoForm = new Empleado();
        empleadoForm.setVisible(true);*/
       
       Entrada splash = new Entrada(4000); // Duración del splash screen en milisegundos
       splash.showSplash();
       
       Superior superiorForm = new Superior();
       superiorForm.setVisible(true);

    }
    
}
