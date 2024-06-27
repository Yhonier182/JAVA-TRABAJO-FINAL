/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ProductoDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Producto;
import views.vistaProducto;

/**
 * @author JHONIER ARIAS
 */
public class controlador implements ActionListener {
    ProductoDAO dao = new ProductoDAO();
    Producto pro = new Producto();
    vistaProducto vista = new vistaProducto();
    DefaultTableModel modelo = new DefaultTableModel();

    public controlador(vistaProducto v) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== vista.btnMostrar){
           mostrar(vista.tablaProducto); 
       }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void mostrar(JTable tabla) {
        modelo = (DefaultTableModel)tabla.getModel();
        List<Producto> producto = dao.leerProductos();
        Object[] object = new Object[4];  // crear un arreglo de 4 campos.
        for (int i = 0; i < producto.size(); i++) {
            object[0] = producto.get(i);
            object[1] = producto.get(i);
            object[2] = producto.get(i);
            object[3] = producto.get(i);
            modelo.addRow(object);
        }vista.tablaProducto.setModel(modelo);
    }

}
