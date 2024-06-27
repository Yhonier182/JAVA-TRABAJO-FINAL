package lOGICAMODELO;


import CONEXION.ConexionDB;
import MODELO.Propiedades;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logicaPropiedades {
    private final Connection conexion;
    private final ConexionDB conexionDB;

    public logicaPropiedades(){
        conexionDB = new ConexionDB();
        conexion = ConexionDB.getConexion();
    }

    public void registrarPropiedades(Propiedades valor) {
        String sql = "INSERT INTO propiedades (nombrePropiedad,direccion,tipoDePropiedad,tamano,numhabitaciones,precio,disponibilidad) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setString(1,valor.getNombrePropiedad());
            preparedStatement.setString(2,valor.getDireccion());
            preparedStatement.setString(3,valor.getTipoDePropiedad());
            preparedStatement.setString(4,valor.getTamano());
            preparedStatement.setInt(5,valor.getNumhabitaciones());
            preparedStatement.setInt(6,valor.getPrecio());
            preparedStatement.setString(7,valor.getDisponibilidad());
            
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null,"Registro Exitoso");

        } catch (SQLException e) {
            System.out.println("error : "+e.getMessage());
        }
        conexionDB.closeConexion(conexion);
    }

    public void actualizarPropiedad(Propiedades propiedad, int id) {
        String sql = "UPDATE propiedades SET nombrePropiedad = ? , direccion = ?, tipoDePropiedad = ?," +
                " tamano = ?, numhabitaciones =?, precio =?, disponibilidad = ? WHERE idpropiedades = "+id+" ";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1,propiedad.getNombrePropiedad());
            preparedStatement.setString(2,propiedad.getDireccion());
            preparedStatement.setString(3,propiedad.getTipoDePropiedad());
            preparedStatement.setString(4, propiedad.getTamano());
            preparedStatement.setInt(5, propiedad.getNumhabitaciones());
            preparedStatement.setInt(6,propiedad.getPrecio());
            preparedStatement.setString(7,propiedad.getDisponibilidad());

            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"! Actualizado ¡");
        } catch (SQLException e) {
            System.out.println("error: "+e.getMessage());
//            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage());
        }
        conexionDB.closeConexion(conexion);
    }

    public void eliminarPropiedad(int id) {
        String sql = "DELETE FROM propiedades WHERE idpropiedades = "+id+" ";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "ELIMINADO CON EXITO.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: " + e.getMessage());
        } conexionDB.closeConexion(conexion);

    }

    public void mostrarPropiedades(JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre Propiedad");
        modelo.addColumn("Direccion");
        modelo.addColumn("Tipo Propiedad");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Habitaciones");
        modelo.addColumn("Precio");
        modelo.addColumn("Disponibilidad");
        String sql = "select  * from propiedades";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object[] lista = {
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7),
                        resultSet.getString(8)
                };
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }

    public void consultarPropiedades(String valor, JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre Propiedad");
        modelo.addColumn("Direccion");
        modelo.addColumn("Tipo Propiedad");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Habitaciones");
        modelo.addColumn("Precio");
        modelo.addColumn("Disponibilidad");
        String sql = "select  * from propiedades where  concat( direccion, disponibilidad) like ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, "%" + valor + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object[] lista = {
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getInt(7),
                        resultSet.getString(8)
                };
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }

}
