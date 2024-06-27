package CONTROLADOR;


import MODELO.alquiler;
import Vistas.vistaAlquiler;

import Vistas.vistaArrendatarios;
import Vistas.vistaPropiedades;
import lOGICAMODELO.logicaAlquiler;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controladorAlquiler implements ActionListener, ListSelectionListener, DocumentListener {


    vistaArrendatarios vistaArrendatarios;
    vistaPropiedades vistaPropiedades;
    vistaAlquiler vistaAlquiler;


    public controladorAlquiler(Vistas.vistaArrendatarios vistaArrendatarios, Vistas.vistaPropiedades vistaPropiedades, Vistas.vistaAlquiler vistaAlquiler) {
        this.vistaArrendatarios = vistaArrendatarios;
        this.vistaPropiedades = vistaPropiedades;
        this.vistaAlquiler = vistaAlquiler;
        this.vistaAlquiler.txtBuscar.getDocument().addDocumentListener(this);
        this.vistaAlquiler.tablaAlquiler.getSelectionModel().addListSelectionListener(this);
        this.vistaAlquiler.btnRegistrarAlquier.addActionListener(this);
        this.vistaAlquiler.btnEliminarAlquiler.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaAlquiler.btnRegistrarAlquier) {
            String nombreArrendatario = vistaAlquiler.txtNombreArrendatario.getText();
            String nombrePropiedad = vistaAlquiler.txtxnombrePropiedad.getText();

            alquiler nuevoalquiler = new alquiler(nombreArrendatario,nombrePropiedad);
            logicaAlquiler registrarAlquiler = new logicaAlquiler();
            registrarAlquiler.registrarAlquiler(nuevoalquiler);
            JOptionPane.showMessageDialog(null,"Registro Etixoso");

            logicaAlquiler tablaAlquiler = new logicaAlquiler();
            tablaAlquiler.mostrarAlquiler(vistaAlquiler.tablaAlquiler);
            buscar();
            limpiar();


        }
         if (e.getSource()== vistaAlquiler.btnEliminarAlquiler){
             int idalquiler = Integer.parseInt(vistaAlquiler.txtIDalquiler.getText());
             alquiler eliminarAlquiler = new alquiler(idalquiler);
             logicaAlquiler logicaAlquiler = new logicaAlquiler();
             logicaAlquiler.eliminarAlquiler(eliminarAlquiler);

             logicaAlquiler tablaAlquiler = new logicaAlquiler();
             tablaAlquiler.mostrarAlquiler(vistaAlquiler.tablaAlquiler);
             buscar();
             limpiar();

         }

    }


    public void buscar() {
        String valor = vistaAlquiler.txtBuscar.getText();
        logicaAlquiler x = new logicaAlquiler();
        x.consultarAlquiler(vistaAlquiler.tablaAlquiler,valor);
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
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int filaSeleccionada = vistaAlquiler.tablaAlquiler.getSelectedRow();
            if (filaSeleccionada >= 0) {
                TableModel modelo = vistaAlquiler.tablaAlquiler.getModel();
                Object ID_alquiler = modelo.getValueAt(filaSeleccionada, 0);
                Object Nombre_Arrendatario = modelo.getValueAt(filaSeleccionada, 1);
                Object Identificacion = modelo.getValueAt(filaSeleccionada,2);
                Object Nombre_Propiedad = modelo.getValueAt(filaSeleccionada, 3);
                Object Tipo_Propiedad = modelo.getValueAt(filaSeleccionada, 4);
                Object precio = modelo.getValueAt(filaSeleccionada, 5);
                Object Estado = modelo.getValueAt(filaSeleccionada, 6);

                vistaAlquiler.txtIDalquiler.setText(ID_alquiler.toString());
                vistaAlquiler.txtNombreArrendatario.setText(Nombre_Arrendatario.toString());
                vistaAlquiler.txtIDarredatario.setText(Identificacion.toString());
                vistaAlquiler.txtxnombrePropiedad.setText(Nombre_Propiedad.toString());
                vistaAlquiler.boxTIPOPRO.setSelectedItem(Tipo_Propiedad.toString());
                vistaAlquiler.txtPRECIO.setText(precio.toString());
                vistaAlquiler.boXESTADO.setSelectedItem(Estado.toString());

                System.out.println("Fila seleccionada: " + filaSeleccionada);
            }
        }
    }

    public void limpiar (){
        vistaAlquiler.txtIDalquiler.setText("");
        vistaAlquiler.txtIDarredatario.setText("");
        vistaAlquiler.txtNombreArrendatario.setText("");
        vistaAlquiler.txtxnombrePropiedad.setText("");
        vistaAlquiler.txtPRECIO.setText("");
    }

}
