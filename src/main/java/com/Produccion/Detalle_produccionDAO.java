package com.Produccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.coffee.coffee.Conexión.DbConnection;
@Repository

public class Detalle_produccionDAO {
    private DbConnection db;
    public Detalle_produccionDAO(DbConnection db) {
        this.db = db;
    }
    
    public void registrarDetalleProduccion(detalle_produccion detalle) {
        String sql = "INSERT INTO detalle_produccion (produccion_idproduccion, Articulo_idtArticulo, Cantidad_consumida, idAlmacen) VALUES (?, ?, ?,? )";
        
        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
             
            stmt.setInt(1, detalle.getProduccion().getIdProduccion());
            stmt.setInt(2, detalle.getArticulo().getIdArticulo());
            stmt.setInt(3, detalle.getCantidadConsumida());
            stmt.setInt(4, detalle.getAlmacen().getIdAlmacen());

            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println(" Detalle de producción registrado exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println(" Error al registrar el detalle de producción: " + e.getMessage());
        }
    }
    
    public void actualizarDetalleProduccion(detalle_produccion detalle) {
        String sql = "UPDATE detalle_produccion SET Cantidad_consumida = ?, idAlmacen = ? WHERE produccion_idproduccion = ? AND Articulo_idtArticulo = ?";
        
        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
             
            stmt.setInt(1, detalle.getCantidadConsumida());
            stmt.setInt(2, detalle.getAlmacen().getIdAlmacen());
            stmt.setInt(3, detalle.getProduccion().getIdProduccion());
            stmt.setInt(4, detalle.getArticulo().getIdArticulo());
            
            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println(" Detalle de producción actualizado exitosamente.");
            }
        } catch (SQLException e) {
            System.out.println(" Error al actualizar el detalle de producción: " + e.getMessage());
        }
    }
}
