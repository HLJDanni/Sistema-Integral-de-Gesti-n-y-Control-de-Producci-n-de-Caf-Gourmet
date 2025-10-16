package com.Modelo.Inventario;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventarioService {

    private final inventarioDAO dao;

    //@Autowired
    public InventarioService(inventarioDAO dao) {
        this.dao = dao;
    }

    public void guardarInventario(InventarioMod inventario) {
        try {
            // Consultar el stock actual
            Double stockActual = dao.consultarInventario(
                inventario.getArticulo().getIdArticulo(),
                inventario.getAlmacen().getIdAlmacen()
            );

            // Si no existe el registro → insertar
            if (dao.existencia(inventario.getArticulo().getIdArticulo(), inventario.getAlmacen().getIdAlmacen())) {
                // Si existe → actualizar sumando la cantidad
                double nuevaCantidad = stockActual + inventario.getCantidad();
                dao.actualizarInventario(
                    inventario.getArticulo(),
                    inventario.getAlmacen(),
                    nuevaCantidad
                );
                System.out.println("Inventario actualizado (nueva cantidad: " + nuevaCantidad + ")");
                
            } else {
                
            dao.insertarInventario(inventario);
                System.out.println("Nuevo inventario insertado.");
            }

        } catch (Exception e) {
            System.out.println("Error en guardarInventario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarInventario(InventarioMod inventario) {
        try {
            dao.eliminarInventario(inventario);
            System.out.println("Inventario eliminado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
