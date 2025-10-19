package com.Modelo.Inventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.beans.factory.annotation.Autowired;
import com.coffee.coffee.Conexión.DbConnection;

@Repository
public class inventarioDAO {

    private final DbConnection db;

  //@Autowired
    public inventarioDAO(DbConnection db) {
        this.db = db;
    }
    public List<InventarioMod> listarInventario() {
        List<InventarioMod> lista = new ArrayList<>();

        String sql = "SELECT idtArticulo, idAlmacen, stock, Fecha_Actualizacion FROM inventario";

        try (Connection con = db.getConnection();
         PreparedStatement stmt = con.prepareStatement(sql);
         var rs = stmt.executeQuery()) {

            while (rs.next()) {
            InventarioMod inv = new InventarioMod();

              
                inv.getArticulo().setIdArticulo(rs.getInt("idtArticulo"));
                inv.getAlmacen().setIdAlmacen(rs.getInt("idAlmacen"));
                inv.setCantidad(rs.getDouble("stock"));
                inv.setFechaActualizacion(rs.getString("Fecha_Actualizacion"));

                lista.add(inv);
        }

    } catch (SQLException e) {
        System.out.println("Error al listar inventario: " + e.getMessage());
    }

    return lista;
}




        @GetMapping("/consultar")
    public Double consultarInventario(int idArticulo, int idAlmacen) {
        String sql = "SELECT stock FROM inventario WHERE idtArticulo = ? AND idAlmacen = ?";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

             stmt.setInt(1, idArticulo);
             stmt.setInt(2, idAlmacen);

            var rs = stmt.executeQuery();   
            if (rs.next()) {
                return rs.getDouble("stock");
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar stock: " + e.getMessage());
        }
        return null; // No existe registro
    }   

    public boolean existencia(int idArticulo, int idAlmacen) {
        String sql = "SELECT stock FROM inventario WHERE idtArticulo = ? AND idAlmacen = ? ";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

             stmt.setInt(1, idArticulo);
             stmt.setInt(2, idAlmacen);

            var rs = stmt.executeQuery();
            return rs.next();
            
        } catch (SQLException e) {
            System.out.println("Error al consultar stock: " + e.getMessage());
        }
        return false; // No existe registro
    }   

     @PostMapping("/crear")
    public void insertarInventario( InventarioMod inventario) {
        String sql = "INSERT INTO inventario (idtArticulo, IdAlmacen, stock, Fecha_Actualizacion) VALUES (?, ?, ?, ?)";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, inventario.getArticulo().getIdArticulo());
            stmt.setInt(2, inventario.getAlmacen().getIdAlmacen());
            stmt.setDouble(3, inventario.getCantidad());
            stmt.setString(4, inventario.getFechaActualizacion());

            stmt.executeUpdate();
            System.out.println(" Inventario insertado correctamente");

        } catch (SQLException e) {
            System.out.println(" Error al insertar inventario: " + e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public void actualizarInventario( articulo articulo, almacen almacen, double nuevaCantidad) {
        String sql = "UPDATE inventario SET stock = ?, Fecha_Actualizacion = ? WHERE idAlmacen = ? AND idtArticulo = ? ";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDouble(1, nuevaCantidad);
            stmt.setString(2, java.time.LocalDate.now().toString());
            stmt.setInt(3, almacen.getIdAlmacen());
             stmt.setInt(4, articulo.getIdArticulo());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println(" Cantidad de inventario actualizada correctamente");
            } else {
                System.out.println(" No se encontró articulo con ID: " + articulo.getIdArticulo() + " en Almacén ID: " + almacen.getIdAlmacen() );
            }

        } catch (SQLException e) {
            System.out.println(" Error al actualizar inventario: " + e.getMessage());
        }
    }

     @DeleteMapping("/eliminar")
    public void eliminarInventario( InventarioMod inventario) {
        String sql = "DELETE FROM inventario WHERE idAlmacen = ? AND idtArticulo = ?";

        try (Connection con = db.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setInt(1, inventario.getAlmacen().getIdAlmacen());
            stmt.setInt(2, inventario.getArticulo().getIdArticulo());
            stmt.executeUpdate();

            System.out.println(" Inventario eliminado correctamente");

        } catch (SQLException e) {
            System.out.println(" Error al eliminar inventario: " + e.getMessage());
        }
    }
}
