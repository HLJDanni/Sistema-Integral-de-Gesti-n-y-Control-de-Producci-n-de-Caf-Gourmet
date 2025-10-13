package com.Produccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Modelo.Inventario.articulo;
import com.coffee.coffee.Conexión.DbConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.weaver.ast.Test;

public class produccionDAO {
    
    public void obtenerproducto() {
        String sql = "SELECT idArticulo From Articulo WHERE tipoArticulo = 'Producto'";

        try (Connection con = new DbConnection().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, articulo.getIdArticulo());
            
            stmt.executeUpdate();

            System.out.println("Inventario insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void actualizarProduccion(produccion prod) {
        // Lógica para actualizar la producción en la base de datos
    }
    public void eliminarProduccion(int idProduccion) {
        // Lógica para eliminar la producción de la base de datos
    }

    public void registrarProduccion(produccion prod) {
        try {
            produccionDAO dao = new produccionDAO();
            dao.obtenerproducto();
            System.out.println("Producción registrada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
