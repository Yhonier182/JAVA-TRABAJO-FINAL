/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heladeria;

import com.mycompany.heladeria.Producto;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Menu extends Producto{
    
    private String tipoProducto;
    private String Ingredientes;
    private int canIngredientes;
    private String ingreAdd;

    public Menu(String tipoProducto, String Ingredientes, int canIngredientes, String ingreAdd, String codigo, String nombre, double precio, String sabor, String tamaño) {
        super(codigo, nombre, precio, sabor, tamaño);
        this.tipoProducto = tipoProducto;
        this.Ingredientes = Ingredientes;
        this.canIngredientes = canIngredientes;
        this.ingreAdd = ingreAdd;
    }
    
    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getIngredientes() {
        return Ingredientes;
    }

    public void setIngredientes(String Ingredientes) {
        this.Ingredientes = Ingredientes;
    }

    public int getCanIngredientes() {
        return canIngredientes;
    }

    public void setCanIngredientes(int canIngredientes) {
        this.canIngredientes = canIngredientes;
    }

    public String getIngreAdd() {
        return ingreAdd;
    }

    public void setIngreAdd(String ingreAdd) {
        this.ingreAdd = ingreAdd;
    }

        

    

    
   
    
    
    
    
    
    
}
