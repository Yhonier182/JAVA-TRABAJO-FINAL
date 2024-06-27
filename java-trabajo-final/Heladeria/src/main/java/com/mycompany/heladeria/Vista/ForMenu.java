/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.heladeria.Vista;

import com.mycompany.heladeria.OrdenPedido;
import javax.swing.*;

public class ForMenu extends JFrame {
    
    private JTextField Nmesatx;
    private JTextField Npedidotx;
    private JTextField fechatx;
    private JTextField tipoProductotx;
    private JTextField ingredientestx;
    private JTextField canIngredientestx;
    private JTextField ingreAddtx;
    private JTextField codigotx;
    private JTextField nombretx;
    private JTextField preciotx;
    private JTextField sabortx;
    private JTextField tamañotx;
    
    public ForMenu() {
        super("Menu");
        setSize (600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        Npedidotx = new JTextField(20);
        Nmesatx = new JTextField(20);
        fechatx = new JTextField(20);
        tipoProductotx = new JTextField(20);
        ingredientestx = new JTextField(20);
        canIngredientestx = new JTextField(20);
        ingreAddtx = new JTextField(20);
        codigotx = new JTextField(20);
        nombretx = new JTextField(20);
        preciotx = new JTextField(20);
        sabortx = new JTextField(20);
        tamañotx = new JTextField(20);
        
        panel.add(new JLabel("Orden de pedido número: "));
        panel.add(Npedidotx);
        panel.add(new JLabel("Mesa número: "));
        panel.add(Nmesatx);
        panel.add(new JLabel("Fecha pedido: "));
        panel.add(fechatx);
        panel.add(new JLabel("Tipo de producto: "));
        panel.add(tipoProductotx);
        panel.add(new JLabel("Ingredientes: "));
        panel.add(ingredientestx);
        panel.add(new JLabel("Cantidad de ingredientes: "));
        panel.add(canIngredientestx);
        panel.add(new JLabel("Ingredientes adicionales: "));
        panel.add(ingreAddtx);
        panel.add(new JLabel("Código del producto: "));
        panel.add(codigotx);
        panel.add(new JLabel("Nombre del producto: "));
        panel.add(nombretx);
        panel.add(new JLabel("Precio: "));
        panel.add(preciotx);
        panel.add(new JLabel("Sabores bolas: "));
        panel.add(sabortx);
        panel.add(new JLabel("Tamaño producto: "));
        panel.add(tamañotx);
        
           JButton guardarButton = new JButton ("Guardar");
        guardarButton.addActionListener(e -> guardarPedido());
        panel.add(guardarButton);

        add(panel);

        setLocationRelativeTo(null);

        setVisible(true);    
    }
        
         private void guardarPedido() {
        
        int Npedido = Integer.parseInt(Npedidotx.getText());
        int Nmesa = Integer.parseInt(Nmesatx.getText());
        String fecha = fechatx.getText();
        String tipoProducto = tipoProductotx.getText();
        String ingredientes = ingredientestx.getText();
        int canIngredientes = Integer.parseInt(canIngredientestx.getText());
        String ingreAdd = ingreAddtx.getText();
        String codigo = codigotx.getText();
        String nombre = nombretx.getText();
        double precio = Double.parseDouble(preciotx.getText());
        String sabor = sabortx.getText();
        String tamaño = tamañotx.getText();
        
        OrdenPedido pedido = new OrdenPedido (Npedido, Nmesa, fecha, tipoProducto, ingredientes, canIngredientes, ingreAdd,codigo, nombre, precio, sabor, tamaño);
        mostrarPedido (pedido);
        
    }
    
    private void mostrarPedido(OrdenPedido pedido){
        String Mensaje = "Orden de pedido número: " + pedido.getNpedido()
                + "\nMesa número: " + pedido.getNmesa()
                + "\nfecha: " + pedido.getFecha()
                +"Tipo de producto: " + pedido.getTipoProducto()
                + "\nIngredientes: " + pedido.getIngredientes()
                + "\nCantidad de ingredientes: " + pedido.getCanIngredientes()
                + "\nIngredientes adicionales: " + pedido.getIngreAdd()
                + "\nCódigo del producto: " + pedido.getCodigo()
                + "\nNombre: " + pedido.getNombre()
                + "\nPrecio: " + pedido.getPrecio()
                + "\nSabor: " + pedido.getSabor()
                + "\nTamaño del producto: " + pedido.getTamaño();
                
        JOptionPane.showMessageDialog(null, Mensaje, "Información del pedido", JOptionPane.INFORMATION_MESSAGE);
    }
        
    }
    
    
    
    

