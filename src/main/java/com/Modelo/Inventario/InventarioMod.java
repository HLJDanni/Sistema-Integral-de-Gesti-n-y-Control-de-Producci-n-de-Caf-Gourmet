
package com.Modelo.Inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.coffee.coffee.Conexión.DbConnection;

public class InventarioMod {
    private int idInventario;
    private articulo articulo;
    private double cantidad; // en la unidad del artículo

    private String fechaActualizacion;

    // Getters y setters
    public int getIdInventario() { return idInventario; }
    public void setIdInventario(int idInventario) { this.idInventario = idInventario; }
    public articulo getArticulo() { return articulo; }
    public void setArticulo(articulo articulo) { this.articulo = articulo; }
    public double getCantidad() { return cantidad; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }
    public String getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(String fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }

    public void actualizarCantidad(int idInventario, double nuevaCantidad) {
        String sql = "UPDATE inventario SET cantidad = ?, fechaActualizacion = ? WHERE idInventario = ?";

        try (Connection con = new DbConnection().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDouble(1, nuevaCantidad);
            stmt.setString(2, java.time.LocalDate.now().toString());
            stmt.setInt(3, idInventario);
            stmt.executeUpdate();

            System.out.println("Cantidad de inventario actualizada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarInventario(int idInventario) {
        String sql = "DELETE FROM inventario WHERE idInventario = ?";

        try (Connection con = new DbConnection().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idInventario);
            stmt.executeUpdate();

            System.out.println("Inventario eliminado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}