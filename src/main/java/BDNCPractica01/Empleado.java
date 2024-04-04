package BDNCPractica01;

import java.sql.*;
import BDNCPractica01.ConexionDB;

public class Empleado implements EmpleadoDAO {
    private static Empleado instance;
    private Connection conn;

    private Empleado() {
        try {
            conn = ConexionDB.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Empleado getInstance() {
        if (instance == null) {
            instance = new Empleado();
        }
        return instance;
    }

    @Override
    public void agregarEmpleado(int id, String nombre, String direccion, String telefono, int idDepartamento) {
        String sql = "INSERT INTO empleados (clave, nombre, direccion, telefono, departamento) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, direccion);
            stmt.setString(4, telefono);
            stmt.setInt(5, idDepartamento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listarEmpleados() {
        String sql = "SELECT * FROM empleados";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("clave") + ", Nombre: " + rs.getString("nombre") +
                                   ", Direccion: " + rs.getString("direccion") + ", Telefono: " + rs.getString("telefono") +
                                   ", ID Departamento: " + rs.getInt("departamento"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarEmpleado(int id, String nombre, String direccion, String telefono, int idDepartamento) {
        String sql = "UPDATE empleados SET nombre = ?, direccion = ?, telefono = ?, departamento = ? WHERE clave = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, direccion);
            stmt.setString(3, telefono);
            stmt.setInt(4, idDepartamento);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEmpleado(int id) {
        String sql = "DELETE FROM empleados WHERE clave = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}