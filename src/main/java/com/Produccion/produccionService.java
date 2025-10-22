package com.Produccion;

import com.Modelo.Inventario.InventarioMod;
import com.Modelo.Inventario.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class produccionService {

    @Autowired
    private produccionDAO produccionDAO;

    @Autowired
    private Detalle_produccionDAO detalleDAO;

    @Autowired(required = false)
    private InventarioService inventarioService; // opcional, si manejas stock

    /**
     * Guarda una producción con sus detalles.
     */
    @Transactional
    public void guardarProduccion(produccion produccion) {
        try {
            // Registrar la producción principal
            int idGenerado = produccionDAO.registrarProduccion(produccion);
            produccion.setIdProduccion(idGenerado);

            // Registrar los detalles asociados
            if (produccion.getDetalles() != null && !produccion.getDetalles().isEmpty()) {
                for (detalle_produccion detalle : produccion.getDetalles()) {
                    // Asignar la producción actual al detalle
                    detalle.setProduccion(produccion);

                    // Registrar el detalle
                    detalleDAO.registrarDetalleProduccion(detalle);

                    // Actualizar inventario
                   if (inventarioService != null) {
                        InventarioMod inventario = new InventarioMod();
                        inventario.setArticulo(detalle.getArticulo());
                        inventario.setAlmacen(detalle.getAlmacen());
                        inventario.setCantidad(-detalle.getCantidadConsumida()); // reducir stock

                         inventarioService.guardarInventario(inventario);
}
                }
            }
             // Sumar stock del artículo producido 
        if (inventarioService != null) {
            InventarioMod inventarioEncabezado = new InventarioMod();
            inventarioEncabezado.setArticulo(produccion.getArticulo()); // artículo final
            inventarioEncabezado.setAlmacen(produccion.getAlmacenDestino()); // almacén de destino
            inventarioEncabezado.setCantidad(produccion.getCantidadProducida()); 
            inventarioService.guardarInventario(inventarioEncabezado);
        }

            System.out.println("Producción y detalles guardados correctamente.");

        } catch (Exception e) {
            System.err.println(" Error al guardar la producción: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al guardar la producción", e);
        }
    }

    /**
     * Actualiza una producción existente y sus detalles.
     */
    @Transactional
    public void actualizarProduccion(produccion produccion) {
        try {
            produccionDAO.actualizarporduccion(produccion);

            if (produccion.getDetalles() != null && !produccion.getDetalles().isEmpty()) {
                for (detalle_produccion detalle : produccion.getDetalles()) {
                    detalleDAO.actualizarDetalleProduccion(detalle);
                }
            }

            System.out.println("Producción actualizada correctamente.");

        } catch (Exception e) {
            System.err.println("Error al actualizar la producción: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la producción", e);
        }
    }
}
