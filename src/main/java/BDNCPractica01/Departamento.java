package BDNCPractica01;

import java.sql.*;
import BDNCPractica01.ConexionDB;

public class Departamento implements DepartamentoDAO {
    private static Departamento instance;
    private Connection conn;

    private Departamento() {
        try {
            conn = ConexionDB.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Departamento getInstance() {
        if (instance == null) {
            instance = new Departamento();
        }
        return instance;
    }

    @Override
    public void agregarDepartamento(int id, String nombre, String clave) {
        String sql = "INSERT INTO departamentos (id, nombre, clave) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, clave);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listarDepartamentos() {
        String sql = "SELECT * FROM departamentos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nombre: " + rs.getString("nombre") + ", Clave: " + rs.getString("clave"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarDepartamento(int id, String nombre, String clave) {
        String sql = "UPDATE departamentos SET nombre = ?, clave = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, clave);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarDepartamento(int id) {
        String sql = "DELETE FROM departamentos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}