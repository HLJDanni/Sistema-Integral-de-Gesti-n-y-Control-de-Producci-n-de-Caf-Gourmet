package com.Produccion;

import com.coffee.coffee.Conexión.DbConnection;
import java.sql.*;
import java.util.*;

public class TareasProduccionDAO {

    public List<TareasProduccion> listarTareas() {
        List<TareasProduccion> lista = new ArrayList<>();
        String sql = "SELECT * FROM tareas_produccion";

        DbConnection db = new DbConnection();

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TareasProduccion tarea = new TareasProduccion(
                        rs.getInt("idtareas_produccion"),
                        rs.getString("descripcion"),
                        rs.getString("fecha_asignacion"),
                        rs.getString("fecha_final"),
                        rs.getString("estado"),
                        rs.getString("tipo_produccion"),
                        rs.getInt("idUsuario")
                );
                lista.add(tarea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insertarTarea(TareasProduccion tarea) {
        String sql = "INSERT INTO tareas_produccion (descripcion, fecha_asignacion, fecha_final, estado, tipo_produccion, idUsuario) VALUES (?, ?, ?, ?, ?, ?)";
        
        DbConnection db = new DbConnection(); 

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tarea.getDescripcion());
            ps.setString(2, tarea.getFecha_asignacion());
            ps.setString(3, tarea.getFecha_final());
            ps.setString(4, tarea.getEstado());
            ps.setString(5, tarea.getTipo_produccion());
            ps.setInt(6, tarea.getIdUsuario());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarTarea(TareasProduccion tarea) {
        String sql = "UPDATE tareas_produccion SET descripcion=?, fecha_asignacion=?, fecha_final=?, estado=?, tipo_produccion=?, idUsuario=? WHERE idtareas_produccion=?";
        
        DbConnection db = new DbConnection();

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, tarea.getDescripcion());
            ps.setString(2, tarea.getFecha_asignacion());
            ps.setString(3, tarea.getFecha_final());
            ps.setString(4, tarea.getEstado());
            ps.setString(5, tarea.getTipo_produccion());
            ps.setInt(6, tarea.getIdUsuario());
            ps.setInt(7, tarea.getIdtareas_produccion());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarTarea(int id) {
        String sql = "DELETE FROM tareas_produccion WHERE idtareas_produccion=?";
        
        DbConnection db = new DbConnection(); 

        try (Connection conn = db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

