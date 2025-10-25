package com.coffee.coffee.Lotes;

import com.Produccion.produccion;
import com.Modelo.Inventario.articulo;
import com.coffee.coffee.Conexión.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ProductoTermiDAO {
    private final DbConnection db;

    public ProductoTermiDAO(DbConnection db) {
        this.db = db;
    }

    // Guardar un nuevo lote de producto terminado
    public void guardarProductoTerminado(ProductoTerminado producto) {
        String sql = "INSERT INTO producto_terminado (fecha_termino, fecha_vencimiento, Cantidad, Estado, observaciones, idproduccion, Control_calidad) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setObject(1, producto.getFechaTerminado());
            pstmt.setObject(2, producto.getFechaVencimiento());
            pstmt.setDouble(3, producto.getCantidad());
            pstmt.setString(4, producto.getEstado());
            pstmt.setString(5, producto.getObservacion());
            pstmt.setInt(6, producto.getProduccion().getIdProduccion());
            pstmt.setString(7, producto.getControlCalidad());
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error al guardar producto terminado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Actualizar control de calidad y estado
    public void actualizarControlCalidad(ProductoTerminado producto) {
        String sql = "UPDATE producto_terminado SET Estado = ?, observaciones = ?, Control_calidad = ? WHERE idproducto_terminado = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, producto.getEstado());
            pstmt.setString(2, producto.getObservacion());
            pstmt.setString(3, producto.getControlCalidad());
            pstmt.setInt(4, producto.getIdProductoTerminado());
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error al actualizar control de calidad: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Obtener producto terminado por ID (con producción y artículo cargados)
    public ProductoTerminado obtenerProductoPorId(int id) {
        String sql = "SELECT pt.*, p.idProduccion, p.Articulo_idtArticulo, p.cantidad_producida, p.estado AS estado_produccion, " +
                     "p.idtareas_produccion, p.idEtapa, p.Users_idUsuario, p.fecha AS fecha_produccion, p.idAlmacenDestino " +
                     "FROM producto_terminado pt " +
                     "JOIN produccion p ON pt.idproduccion = p.idProduccion " +
                     "WHERE pt.idproducto_terminado = ?";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    ProductoTerminado producto = new ProductoTerminado();
                    producto.setIdProductoTerminado(rs.getInt("idproducto_terminado"));
                    producto.setcantidad(rs.getDouble("Cantidad"));
                    producto.setFechaTerminado(rs.getDate("fecha_termino").toLocalDate());
                    producto.setFechaVencimiento(rs.getDate("fecha_vencimiento").toLocalDate());
                    producto.setEstado(rs.getString("Estado"));
                    producto.setObservacion(rs.getString("observaciones"));
                    producto.setControlCalidad(rs.getString("Control_calidad"));

                    // Cargar producción completa
                    produccion prod = new produccion();
                    prod.setIdProduccion(rs.getInt("idProduccion"));
                    prod.setCantidadProducida(rs.getDouble("cantidad_producida"));
                    prod.setEstado(rs.getString("estado_produccion"));
                    prod.setIdEtapa(rs.getInt("idEtapa"));
                    prod.setIdTareasProduccion(rs.getInt("idtareas_produccion"));

                    // Cargar artículo completo
                    articulo art = new articulo();
                    art.setIdArticulo(rs.getInt("Articulo_idtArticulo"));
                    prod.setArticulo(art);

                    // Cargar almacén destino como int
                    int idAlmacenDestino = rs.getInt("idAlmacenDestino"); // columna en la BD
                    prod.setAlmacenDestino(idAlmacenDestino);

                    producto.setProduccion(prod);

                    return producto;
                }
            }

        } catch (Exception e) {
            System.err.println("Error al obtener producto terminado por ID: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    // Consultar todos los lotes
    public List<ProductoTerminado> consultarLotes() {
        List<ProductoTerminado> lotes = new ArrayList<>();
        String sql = "SELECT * FROM producto_terminado";

        try (Connection conn = db.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ProductoTerminado producto = new ProductoTerminado();
                producto.setIdProductoTerminado(rs.getInt("idproducto_terminado"));
                producto.setFechaTerminado(rs.getDate("fecha_termino").toLocalDate());
                producto.setFechaVencimiento(rs.getDate("fecha_vencimiento").toLocalDate());
                producto.setcantidad(rs.getDouble("Cantidad"));
                producto.setEstado(rs.getString("Estado"));
                producto.setObservacion(rs.getString("observaciones"));
                producto.setControlCalidad(rs.getString("Control_calidad"));

                lotes.add(producto);
            }

        } catch (Exception e) {
            System.err.println("Error al consultar lotes: " + e.getMessage());
            e.printStackTrace();
        }

        return lotes;
    }
}
