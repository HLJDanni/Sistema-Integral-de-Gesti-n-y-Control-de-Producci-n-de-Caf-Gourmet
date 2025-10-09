package com.coffee.coffee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionMP_GranosVerdesAdd {

    private Connection conexion;

    public GestionMP_GranosVerdesAdd() {
        conexion = new DbConnection().getConnection();
    }

    // CREATE
    public boolean agregarTipoGrano(String nombre, String descripcion) {
        String sql = "INSERT INTO tipo_grano (nombre, descripcion) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ
    public List<TipoGrano> obtenerTodos() {
        List<TipoGrano> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, descripcion FROM tipo_grano";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TipoGrano tg = new TipoGrano(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
                );
                lista.add(tg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // UPDATE
    public boolean actualizarTipoGrano(int id, String nombre, String descripcion) {
        String sql = "UPDATE tipo_grano SET nombre = ?, descripcion = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setInt(3, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public boolean eliminarTipoGrano(int id) {
        String sql = "DELETE FROM tipo_grano WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}