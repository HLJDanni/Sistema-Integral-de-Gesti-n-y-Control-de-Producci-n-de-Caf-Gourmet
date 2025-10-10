package com.Modelo.Inventario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coffee.coffee.Conexión.DbConnection;

import java.sql.Connection;


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
    public List<InventarioMod> obtenerProductosConStockBajo() {
        List<InventarioMod> productos = new ArrayList<>();
        String sql = "SELECT i.idInventario, i.idArticulo, i.cantidad, a.nombre " +
                     "FROM inventario i " +
                     "JOIN articulo a ON a.idArticulo = i.idArticulo " +
                     "WHERE i.cantidad < 10"; // ejemplo: stock menor a 10

        try (Connection con = new DbConnection().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                InventarioMod inv = new InventarioMod();
                articulo art = new articulo();
                art.setIdArticulo(rs.getInt("idArticulo"));
                art.setNombre(rs.getString("nombre"));
                inv.setArticulo(art);
                inv.setCantidad(rs.getDouble("cantidad"));
                inv.setIdInventario(rs.getInt("idInventario"));
                productos.add(inv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    // 🔹 NUEVO: crear una orden de compra automática
    public void crearOrdenCompra(List<InventarioMod> productos) {
        try (Connection con = new DbConnection().getConnection()) {
            con.setAutoCommit(false); // para transacción

            String sqlOrden = "INSERT INTO orden_compra (Fecha, Proveedor, Estado, Total, idSocio_negocios, idUsuario) " +
                              "VALUES (NOW(), 'Proveedor automático', 'Pendiente', 0, 1, 1)";
            PreparedStatement psOrden = con.prepareStatement(sqlOrden, Statement.RETURN_GENERATED_KEYS);
            psOrden.executeUpdate();

            ResultSet rs = psOrden.getGeneratedKeys();
            int idOrden = 0;
            if (rs.next()) idOrden = rs.getInt(1);

            String sqlDetalle = "INSERT INTO detalle_orden_compra " +
                                "(idArticulo, idOrden_compra, Nombre, Cantidad, Precio_unidad, Precio_total) " +
                                "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement psDetalle = con.prepareStatement(sqlDetalle);

            for (InventarioMod p : productos) {
                psDetalle.setInt(1, p.getArticulo().getIdArticulo());
                psDetalle.setInt(2, idOrden);
                psDetalle.setString(3, p.getArticulo().getNombre());
                psDetalle.setDouble(4, 10); // cantidad sugerida
                psDetalle.setDouble(5, 50.0); // precio fijo ejemplo
                psDetalle.setDouble(6, 10 * 50.0);
                psDetalle.addBatch();
            }

            psDetalle.executeBatch();
            con.commit();
            System.out.println("Orden de compra generada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
