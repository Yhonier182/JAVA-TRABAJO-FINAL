/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heladeria;

/**
 *
 * @author Usuario
 */
public class Producto {
    
    private String codigo;
    private String nombre;
    private double precio;
    private String sabor;
    private String tamaño;

        public Producto(String codigo, String nombre, double precio, String sabor, String tamaño) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.sabor = sabor;
            this.tamaño = tamaño;
        }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
    
        
}