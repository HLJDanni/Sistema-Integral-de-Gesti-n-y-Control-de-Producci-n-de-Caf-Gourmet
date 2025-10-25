package com.coffee.coffee.Lotes;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Modelo.Inventario.InventarioMod;
import com.Modelo.Inventario.InventarioService;
import com.Produccion.produccion;
import com.Produccion.produccionDAO;
import com.Modelo.Inventario.almacen;

@Service
public class ProductoTermiService {

    private final ProductoTermiDAO db;
    private final produccionDAO produccionDAO;
    private final InventarioService inventarioService;

    public ProductoTermiService(ProductoTermiDAO db, produccionDAO produccionDAO, InventarioService inventarioService) {
        this.db = db;
        this.produccionDAO = produccionDAO;
        this.inventarioService = inventarioService;
    }

    // 1️⃣ Registrar lote con estado Pendiente
    @Transactional
    public void registrarLote(ProductoTerminado producto) {
        producto.setEstado("Pendiente");
        producto.setControlCalidad(null);
        db.guardarProductoTerminado(producto);
        System.out.println("Lote creado en estado pendiente de control de calidad.");
    }

    // 2️⃣ Registrar control de calidad y actualizar producción + inventario
    @Transactional
    public void registrarControlCalidad(int idProductoTerminado, String resultado, String observaciones) {
        ProductoTerminado producto = db.obtenerProductoPorId(idProductoTerminado);

        if (producto != null) {
            producto.setControlCalidad(resultado);
            producto.setObservacion(observaciones);

            if ("Aprobado".equalsIgnoreCase(resultado)) {
                producto.setEstado("Aprobado");

                produccion prod = producto.getProduccion();
                if (prod != null) {
                    prod.setEstado("Cerrada");
                    produccionDAO.actualizarporduccion(prod);

                    try {
                        // Validar datos mínimos
                        if (inventarioService != null && prod.getArticulo() != null && prod.getAlmacenDestino() > 0) {
                            // Crear un objeto almacen temporal con el ID
                            almacen alm = new almacen();
                            alm.setIdAlmacen(prod.getAlmacenDestino());

                            // Crear el registro de inventario
                            InventarioMod inv = new InventarioMod();
                            inv.setArticulo(prod.getArticulo());
                            inv.setAlmacen(alm);
                            inv.setCantidad(prod.getCantidadProducida());
                            inv.setFechaActualizacion(java.time.LocalDate.now().toString());

                            // Insertar o actualizar según exista
                            inventarioService.guardarInventario(inv);
                            System.out.println("🆕 Inventario actualizado para artículo ID " + prod.getArticulo().getIdArticulo());
                        } else {
                            System.out.println("⚠️ No se pudo actualizar el inventario (servicio o datos incompletos).");
                        }
                    } catch (Exception e) {
                        System.err.println("❌ Error al actualizar inventario: " + e.getMessage());
                        e.printStackTrace();
                    }
                }

            } else if ("Rechazado".equalsIgnoreCase(resultado)) {
                producto.setEstado("Rechazado");
            } else {
                producto.setEstado("Pendiente");
            }

            db.actualizarControlCalidad(producto);
            System.out.println("Control de calidad registrado para lote ID: " + idProductoTerminado +
                               " -> Estado: " + producto.getEstado());
        } else {
            System.out.println("No se encontró el lote con ID: " + idProductoTerminado);
        }
    }

    // 3️⃣ Consultar lote por ID
    @Transactional(readOnly = true)
    public ProductoTerminado obtenerLotePorId(int idProductoTerminado) {
        return db.obtenerProductoPorId(idProductoTerminado);
    }

    // 4️⃣ Consultar todos los lotes
    @Transactional(readOnly = true)
    public java.util.List<ProductoTerminado> consultarLotes() {
        return db.consultarLotes();
    }
}
