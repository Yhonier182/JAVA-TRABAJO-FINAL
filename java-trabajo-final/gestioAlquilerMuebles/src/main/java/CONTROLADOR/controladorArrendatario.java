/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

import MODELO.arrendatario;
import Vistas.vistaArrendatarios;
import lOGICAMODELO.logicaArrendatario;


import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JHONIER ARIAS
 */
public class controladorArrendatario implements ActionListener , ListSelectionListener, DocumentListener {

    vistaArrendatarios vistaArrendatarios;
//    public static tablas tablas;



    public controladorArrendatario(Vistas.vistaArrendatarios vistaArrendatarios) {

        this.vistaArrendatarios = vistaArrendatarios;
        this.vistaArrendatarios.btnRegistrarA.addActionListener(this);
        this.vistaArrendatarios.btnActualizarA.addActionListener(this);
        this.vistaArrendatarios.btnEliminarA.addActionListener(this);
        this.vistaArrendatarios.btnCancelarA.addActionListener(this);
        this.vistaArrendatarios.txtbuscarArrendatario.getDocument().addDocumentListener(this);
        this.vistaArrendatarios.tablaArrendatarios.getSelectionModel().addListSelectionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== vistaArrendatarios.btnRegistrarA){
            int identifacion = Integer.parseInt(vistaArrendatarios.txtidentificacion.getText());
            String nombre = vistaArrendatarios.txtNombreArrendatario.getText();
            String apellido = vistaArrendatarios.txtApellidoA.getText();
            int  contacto = Integer.parseInt(vistaArrendatarios.txtContactoA.getText());
            String referencias = vistaArrendatarios.txtReferencias.getText();

            arrendatario arrendatario = new arrendatario(identifacion,nombre,apellido,contacto,referencias);

            logicaArrendatario registrar = new logicaArrendatario();
            registrar.registrarArrendatrio(arrendatario);

            logicaArrendatario tablaArrendatario = new logicaArrendatario();
            tablaArrendatario.mostrarArrendatario(vistaArrendatarios.tablaArrendatarios);
            limpiarEntradasARRen();



        }

        if (e.getSource()== vistaArrendatarios.btnActualizarA){
            
            String nombre = vistaArrendatarios.txtNombreArrendatario.getText();
            String apellido = vistaArrendatarios.txtApellidoA.getText();
            int contacto = Integer.parseInt(vistaArrendatarios.txtContactoA.getText());
            String referencias =  vistaArrendatarios.txtReferencias.getText();
            int identificacion = Integer.parseInt(vistaArrendatarios.txtidentificacion.getText());

            arrendatario actulizarARREn = new arrendatario(identificacion,nombre,apellido,contacto,referencias);
            logicaArrendatario logicaArrendatario = new logicaArrendatario();
            logicaArrendatario.actualizarArrendatario(actulizarARREn,identificacion);
//
            logicaArrendatario tablaArrendatario = new logicaArrendatario();
            tablaArrendatario.mostrarArrendatario(vistaArrendatarios.tablaArrendatarios);


            vistaArrendatarios.btnRegistrarA.setEnabled(false);
            vistaArrendatarios.btnEliminarA.setEnabled(false);
            limpiarEntradasARRen();

        }

        if (e.getSource()== vistaArrendatarios.btnEliminarA){
            int id = Integer.parseInt(vistaArrendatarios.txtidentificacion.getText());
            logicaArrendatario logicaArrendatario = new logicaArrendatario();
            logicaArrendatario.eliminarArrendatario(id);

           logicaArrendatario tablaArrendatario = new logicaArrendatario();
            tablaArrendatario.mostrarArrendatario(vistaArrendatarios.tablaArrendatarios);
            limpiarEntradasARRen();


        }
        if (e.getSource()== vistaArrendatarios.btnCancelarA){
            limpiarEntradasARRen();
            vistaArrendatarios.btnActualizarA.setEnabled(true);
            vistaArrendatarios.btnEliminarA.setEnabled(true);
            vistaArrendatarios.btnRegistrarA.setEnabled(true);

            logicaArrendatario tablaArrendatario = new logicaArrendatario();
            tablaArrendatario.mostrarArrendatario(vistaArrendatarios.tablaArrendatarios);

        }
    }

    private void limpiarEntradasARRen() {
        vistaArrendatarios.txtidentificacion.setText("");
        vistaArrendatarios.txtNombreArrendatario.setText("");
        vistaArrendatarios.txtApellidoA.setText("");
        vistaArrendatarios.txtContactoA.setText("");
        vistaArrendatarios.txtReferencias.setText("");
        vistaArrendatarios.txtbuscarArrendatario.setText("");
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            e.getSource();
            vistaArrendatarios.tablaArrendatarios.getSelectionModel();
            int filasObtenidas = vistaArrendatarios.tablaArrendatarios.getSelectedRow();

            if (filasObtenidas >= 0){
                TableModel modelo  = vistaArrendatarios.tablaArrendatarios.getModel();

                Object identificacion = modelo.getValueAt(filasObtenidas,0);
                Object nombre = modelo.getValueAt(filasObtenidas,1);
                Object apellido = modelo.getValueAt(filasObtenidas,2);
                Object contacto = modelo.getValueAt(filasObtenidas,3);
                Object referencias = modelo.getValueAt(filasObtenidas,4);


                vistaArrendatarios.txtidentificacion.setText(identificacion.toString());
                vistaArrendatarios.txtNombreArrendatario.setText(nombre.toString());
                vistaArrendatarios.txtApellidoA.setText(apellido.toString());
                vistaArrendatarios.txtContactoA.setText(contacto.toString());
                vistaArrendatarios.txtReferencias.setText(referencias.toString());



                System.out.println("fila: " + filasObtenidas);
            }
        }

    }

    public void buscar(){
        String valor = vistaArrendatarios.txtbuscarArrendatario.getText();
        logicaArrendatario consultar = new logicaArrendatario();
        consultar.consultarArrendatario(valor,vistaArrendatarios.tablaArrendatarios);
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        buscar();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
         buscar();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
          buscar();
    }
}




