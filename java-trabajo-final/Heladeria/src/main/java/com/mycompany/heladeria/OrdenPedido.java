/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heladeria;

import com.mycompany.heladeria.Menu;

public class OrdenPedido extends Menu {
    
    private int Npedido;
    private int Nmesa;
    private String fecha;

    public OrdenPedido(int canIngredientes, int Nmesa1, String tipoProducto, String Ingredientes, String ingreAdd, int canIngredientes1, String codigo, String nombre, String sabor, double precio, String tamaño, String tamaño1) {
        super(tipoProducto, Ingredientes, canIngredientes, ingreAdd, codigo, nombre, precio, sabor, tamaño);
    }

    public int getNpedido() {
        return Npedido;
    }

    public void setNpedido(int Npedido) {
        this.Npedido = Npedido;
    }

    public int getNmesa() {
        return Nmesa;
    }

    public void setNmesa(int Nmesa) {
        this.Nmesa = Nmesa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
