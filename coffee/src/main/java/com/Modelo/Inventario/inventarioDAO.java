package com.Modelo.Inventario;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.coffee.coffee.DbConnection;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class inventarioDAO {
    public void insertarInventario(InventarioMod inventario) {
        String sql = "INSERT INTO inventario (idArticulo, cantidad, fechaActualizacion) VALUES (?, ?, ?)";

        try (Connection con = new DbConnection().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, inventario.getArticulo().getIdArticulo());
            stmt.setDouble(2, inventario.getCantidad());
            stmt.setString(3, inventario.getFechaActualizacion());
            stmt.executeUpdate();

            System.out.println("Inventario insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
