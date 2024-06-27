package lOGICAMODELO;

import CONEXION.ConexionDB;
import MODELO.alquiler;
import MODELO.arrendatario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logicaAlquiler {
    private final Connection conexion;
    private final ConexionDB conexionDB;

    public logicaAlquiler() {
        conexionDB = new ConexionDB();
        conexion = ConexionDB.getConexion();
    }

    public void registrarAlquiler (alquiler cliente) {

        String sql = "INSERT INTO alquiler (idarrendatario, idpropiedades) VALUES ((SELECT identificacion FROM arrendatario WHERE nombre = ?),(SELECT idpropiedades FROM propiedades WHERE nombrePropiedad = ?))";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1,cliente.getNombreArrendatario());
            preparedStatement.setString(2,cliente.getNombrePropiedad());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        }
        conexionDB.closeConexion(conexion);
    }


    public void eliminarAlquiler (alquiler id){
        String sql = "DELETE FROM alquilerinmueble.alquiler WHERE idalquiler = ? ";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)){
            preparedStatement.setInt(1,id.getIdalquiler());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null,"! ELIMINADO CON EXITO ¡");
        }catch (Exception e){
            System.out.println("erro" + e.getMessage());
        }
    }

    public  void mostrarAlquiler (JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID_alquiler");
        modelo.addColumn("Nombre_Arrendatario");
        modelo.addColumn("Identificacion");
        modelo.addColumn("Nombre_Propiedad");
        modelo.addColumn("Tipo_Propiedad");
        modelo.addColumn("precio");
        modelo.addColumn("Estado");
        String sql = "SELECT * FROM alquilerinmueble.vista_ultimate";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Object[] lista = {
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                };
                modelo.addRow(lista);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            System.out.println("error: " + e.getMessage());
        }

    }
        public void consultarAlquiler (JTable tabla, String valor){
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID_alquiler");
            modelo.addColumn("Nombre_Arrendatario");
            modelo.addColumn("Identificacion");
            modelo.addColumn("Nombre_Propiedad");
            modelo.addColumn("Tipo_Propiedad");
            modelo.addColumn("precio");
            modelo.addColumn("Estado");

            String sql = "SELECT * FROM alquilerinmueble.vista_ultimate where concat(Nombre_Arrendatario) like ?";

            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.setString(1, "%" + valor + "%");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Object[] lista = {
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7)
                    };
                    modelo.addRow(lista);
                }
                tabla.setModel(modelo);
            } catch (SQLException e) {
                System.out.println("error: " + e.getMessage());
            }
        }


    }

