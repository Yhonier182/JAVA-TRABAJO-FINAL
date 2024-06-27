package CONTROLADOR;

import MODELO.Propiedades;
import Vistas.vistaPropiedades;
import lOGICAMODELO.logicaPropiedades;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class controladorPropiedades implements ActionListener, ListSelectionListener, DocumentListener {

    vistaPropiedades vistaPro;
//    public static tablas tablas;

    public controladorPropiedades(vistaPropiedades propiedades) {
        this.vistaPro = propiedades;
        this.vistaPro.btnREGISTRAR.addActionListener(this);
        this.vistaPro.btnActualizar.addActionListener(this);
        this.vistaPro.btnEliminarPRO.addActionListener(this);
        this.vistaPro.txtBuscarPropiedad.getDocument().addDocumentListener(this);
        this.vistaPro.tablaPropiedades.getSelectionModel().addListSelectionListener(this);
        this.vistaPro.btnCancelarPRO.addActionListener(this);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== vistaPro.btnREGISTRAR){

            String nombrePropiedad = vistaPro.txtNOMBRE.getText();
            String direccion = vistaPro.txtDIRECCION.getText();
            String tipoDePropiedad= vistaPro.boxTIPOPRO.getSelectedItem().toString();
            String tamano = vistaPro.txtTAMANO.getText();
            int  numhabitaciones = Integer.parseInt(vistaPro.txtHABITACIONES.getText());
            int precio =Integer.parseInt(vistaPro.txtPRECIO.getText());
            String disponibilidad = vistaPro.boXESTADO.getSelectedItem().toString();

             Propiedades nuevaPRO =  new Propiedades(nombrePropiedad,direccion,tipoDePropiedad, tamano, numhabitaciones, precio, disponibilidad);

             logicaPropiedades nuevalogica = new logicaPropiedades();
             nuevalogica.registrarPropiedades(nuevaPRO);

             logicaPropiedades tablaPropiedades = new logicaPropiedades();
             tablaPropiedades.mostrarPropiedades(vistaPro.tablaPropiedades);

             limpiar();
        }


        if (e.getSource() == vistaPro.btnActualizar) {

            String nombrePropiedad = vistaPro.txtNOMBRE.getText();
            String direccion = vistaPro.txtDIRECCION.getText();
            String tipoDePropiedad = vistaPro.boxTIPOPRO.getSelectedItem().toString();
            String tamano = vistaPro.txtTAMANO.getText();
            int numhabitaciones = Integer.parseInt(vistaPro.txtHABITACIONES.getText());
            int precio = Integer.parseInt(vistaPro.txtPRECIO.getText());
            String disponibilidad = vistaPro.boXESTADO.getSelectedItem().toString();
            int id = Integer.parseInt(vistaPro.txtID.getText());

            Propiedades propiedades = new Propiedades(id,nombrePropiedad, direccion, tipoDePropiedad, tamano, numhabitaciones, precio, disponibilidad);
            logicaPropiedades logicaPropiedades = new logicaPropiedades();
            logicaPropiedades.actualizarPropiedad(propiedades, id);

            logicaPropiedades tablaPropiedades = new logicaPropiedades();
            tablaPropiedades.mostrarPropiedades(vistaPro.tablaPropiedades);

            limpiar();

        }
            if (e.getSource()==vistaPro.btnEliminarPRO){
            int idpropiedades = Integer.parseInt(vistaPro.txtID.getText());
            logicaPropiedades logicaPropiedades = new logicaPropiedades();
            logicaPropiedades.eliminarPropiedad(idpropiedades);

            logicaPropiedades tablaPropiedades = new logicaPropiedades();
            tablaPropiedades.mostrarPropiedades(vistaPro.tablaPropiedades);

            limpiar();
        }

            if (e.getSource()== vistaPro.btnCancelarPRO){



                logicaPropiedades tablaPropiedades = new logicaPropiedades();
                tablaPropiedades.mostrarPropiedades(vistaPro.tablaPropiedades);

                limpiar();
            }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            e.getSource();
            vistaPro.tablaPropiedades.getSelectionModel();
            int filasObtenidas = vistaPro.tablaPropiedades.getSelectedRow();

            if (filasObtenidas >= 0){
                TableModel modelo  = vistaPro.tablaPropiedades.getModel();


                Object idpropiedades = modelo.getValueAt(filasObtenidas,0);
                Object nombrePropiedad = modelo.getValueAt(filasObtenidas,1);
                Object direccion = modelo.getValueAt(filasObtenidas,2);
                Object tipoDePropiedad= modelo.getValueAt(filasObtenidas,3);
                Object tamaño = modelo.getValueAt(filasObtenidas,4);
                Object numhabitaciones = modelo.getValueAt(filasObtenidas,5);
                Object precio = modelo.getValueAt(filasObtenidas,6);
                Object disponibilidad = modelo.getValueAt(filasObtenidas,7);

                vistaPro.txtID.setText(idpropiedades.toString());
                vistaPro.txtNOMBRE.setText(nombrePropiedad.toString());
                vistaPro.txtDIRECCION.setText(direccion.toString());
                vistaPro.boxTIPOPRO.getSelectedItem().toString();
                vistaPro.txtTAMANO.setText(tamaño.toString());
                vistaPro.txtHABITACIONES.setText(numhabitaciones.toString());
                vistaPro.txtPRECIO.setText(precio.toString());
                vistaPro.boXESTADO.getSelectedItem().toString();


                System.out.println("fila: " + filasObtenidas);
            }
        }

    }


    public void buscar(){
        String valor = vistaPro.txtBuscarPropiedad.getText();
        logicaPropiedades x =  new logicaPropiedades();
        x.consultarPropiedades(valor,vistaPro.tablaPropiedades);
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



    private void limpiar() {//Metodo para que se borren los campos del panel
        //se llaman todos los txt y se le da el valor null.. Cuando se llame en otro método él borra los campos
        // una vez ya se corre el metodo.
        vistaPro.txtID.setText("");
        vistaPro.txtNOMBRE.setText("");
        vistaPro.txtPRECIO.setText("");
        vistaPro.txtTAMANO.setText("");
        vistaPro.txtHABITACIONES.setText("");
        vistaPro.txtBuscarPropiedad.setText("");
        vistaPro.txtDIRECCION.setText("");

    }

}
