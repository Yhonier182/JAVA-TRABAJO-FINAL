/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lOGICAMODELO;

import CONEXION.ConexionDB;
import MODELO.arrendatario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author JHONIER ARIAS
 */
public class logicaArrendatario {

    private final Connection conexion;
    private final ConexionDB conexionDB;

    public logicaArrendatario() {
        conexionDB = new ConexionDB();
        conexion = ConexionDB.getConexion();
    }

    public void registrarArrendatrio(arrendatario cliente) {
        String sql = "INSERT INTO arrendatario (identificacion,nombre,apellido, contacto, referencias) VALUES (?, ?, ?,?,?)";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, cliente.getIdentificacion());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getApellido());
            preparedStatement.setInt(4, cliente.getContacto());
            preparedStatement.setString(5, cliente.getReferencias());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro Etixoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage());
        }
        conexionDB.closeConexion(conexion);
    }

    public void actualizarArrendatario(arrendatario cliente, int identificacion) {
        String sql = "UPDATE arrendatario SET nombre = ?, apellido = ?, contacto = ?, referencias = ? WHERE identificacion = "+identificacion+" ";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1,cliente.getNombre());
            preparedStatement.setString(2,cliente.getApellido());
            preparedStatement.setInt(3, cliente.getContacto());
            preparedStatement.setString(4, cliente.getReferencias());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"! Actualizado ¡");
        } catch (SQLException e) {
            System.out.println("error: "+e.getMessage());
//            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        conexionDB.closeConexion(conexion);
    }


    public void eliminarArrendatario(int id) {
        String sql = "DELETE FROM arrendatario WHERE identificacion = "+id+" ";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "ELIMINADO CON EXITO.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: " + e.getMessage());
        } conexionDB.closeConexion(conexion);

    }

    public void mostrarArrendatario(JTable tabla ) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Identificacion");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Contacto");
        modelo.addColumn("Referencias");

        String sql = "select  * from arrendatario";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object[] lista = {
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),

                };
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }

    public void consultarArrendatario(String valor, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Identificacion");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Contacto");
        modelo.addColumn("Referencias");

        String sql = "select  * from arrendatario where  concat(nombre,identificacion) like ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, "%" + valor + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object[] lista = {
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),

                };
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }
}
