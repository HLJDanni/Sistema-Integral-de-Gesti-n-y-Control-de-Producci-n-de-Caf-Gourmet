package com.Produccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Modelo.Inventario.articulo;
import com.coffee.coffee.Conexión.DbConnection;




@Repository
public class produccionDAO {
    private final DbConnection db;
    public produccionDAO(DbConnection db) {
        this.db = db;
    }


    // Método para obtener todos los artículos disponibles
    public List<articulo> obtenerArticulos() {
        List<articulo> lista = new ArrayList<>();
        String sql = "SELECT idArticulo, nombre, tipoArticulo, stock FROM Articulo";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                articulo art = new articulo();
                art.setIdArticulo(rs.getInt("idArticulo"));
                art.setNombre(rs.getString("nombre"));
                //art.setTipoGrano(rs.getString("tipoArticulo"));
                lista.add(art);
            }

        } catch (SQLException e) {
            System.out.println(" Error al obtener artículos: " + e.getMessage());
        }

        return lista;
    }

    public int registrarProduccion(produccion prod) {
        String sql = "INSERT INTO produccion (Articulo_idtArticulo, cantidad_producida, fecha, Users_idUsuario, idEtapa, idtareas_produccion) VALUES (?, ?, ?, ?, ?,?)";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, prod.getArticulo().getIdArticulo());
            stmt.setInt(2, prod.getCantidadProducida());
            java.sql.Date fechaSQL = java.sql.Date.valueOf(prod.getFechaProduccion());
            stmt.setDate(3, fechaSQL);
            stmt.setInt(4, prod.getUsuario().getIdUsuario());
            stmt.setInt(5, prod.getIdEtapa());
            stmt.setInt(6, prod.getIdTareasProduccion());

           
            int filas = stmt.executeUpdate();
            if (filas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);
                        System.out.println(" Producción registrada con ID: " + idGenerado);
                        return idGenerado;
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al registrar producción: " + e.getMessage());
        }
        return -1; // error
    }   

    public void actualizarporduccion(produccion prod) {
        String sql = "UPDATE produccion SET Articulo_idtArticulo = ?, cantidad_producida = ?, fecha = ?, Users_idUsuario = ?, idEtapa = ?, idtareas_produccion = ? WHERE idProduccion = ?";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, prod.getArticulo().getIdArticulo());
            stmt.setInt(2, prod.getCantidadProducida());
            java.sql.Date fechaSQL = java.sql.Date.valueOf(prod.getFechaProduccion());
            stmt.setDate(3, fechaSQL);
            stmt.setInt(4, prod.getUsuario().getIdUsuario());
            stmt.setInt(5, prod.getIdEtapa());
            stmt.setInt(6, prod.getIdTareasProduccion());
            stmt.setInt(7, prod.getIdProduccion());

            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println(" Producción actualizada exitosamente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar producción: " + e.getMessage());
        }
    }

    
}
