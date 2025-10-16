package com.Produccion;
/* 
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
*/
public class produccionDAO {
   /* // obtener lista de artículos
     public List<articulo> obtenerArticulos() {
        List<articulo> lista = new ArrayList<>();
        String sql = "SELECT idArticulo, nombre, tipoArticulo, stock FROM Articulo";

        try (Connection con = new DbConnection().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                articulo art = new articulo();
                art.setIdArticulo(rs.getInt("idArticulo"));
                art.setNombre(rs.getString("nombre"));
                art.setTipoArticulo(rs.getString("tipoArticulo"));
                art.setStock(rs.getDouble("stock"));
                lista.add(art);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }




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
    } */
}
