package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOEmpleado {

    private Connection con;

    public DAOEmpleado() {
        con = DB.getConexion();
    }

    public boolean insert(DTOEmpleado empleado) {
        String sql = "INSERT INTO empleados (nombre, edad, dpto_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, empleado.getNombre());
            stmt.setInt(2, empleado.getEdad());
            stmt.setInt(3, empleado.getDpto_id());
            int rowsInserted = stmt.executeUpdate();
            System.out.println("\nEmpleado agregado con éxito.");
            return rowsInserted > 0;
        } catch (Exception e) {
            System.err.println("\nError al insertar empleado: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // Método para obtener un empleado por ID
    public DTOEmpleado getById(int id) {
        DTOEmpleado empleado = null;
        String sql = "SELECT id, nombre, edad, dpto_id FROM empleados WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empleado = new DTOEmpleado(
                        rs.getString("nombre"),
                        rs.getInt("dpto_id"),
                        rs.getInt("edad")
                );
            }
        } catch (SQLException e) {
            System.err.println("\nError al obtener empleado por ID: " + e.getMessage());
            e.printStackTrace();
        }
        return empleado;
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Empleado con ID " + id + " eliminado con éxito.");
                return true;
            } else {
                System.out.println("No se encontró un empleado con ID " + id + ".");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar empleado: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateEmpleado(int id, DTOEmpleado empleado) {
        String sql = "UPDATE empleados SET nombre = ?, edad = ?, dpto_id = ? WHERE id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, empleado.getNombre());
            stmt.setInt(2, empleado.getEdad());
            stmt.setInt(3, empleado.getDpto_id());
            stmt.setInt(4, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Empleado con ID " + id + " actualizado con éxito.");
                return true;
            } else {
                System.out.println("No se encontró un empleado con ID " + id + ".");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar empleado: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

}