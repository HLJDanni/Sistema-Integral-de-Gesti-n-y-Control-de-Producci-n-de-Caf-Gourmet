package com.coffee.coffee;

import com.Modelo.Inventario.inventarioDAO;
import com.Modelo.Inventario.InventarioMod;
import java.util.List;

public class InventarioService {

    private inventarioDAO dao = new inventarioDAO();

    public boolean generarOrdenSiStockBajo() {
        List<InventarioMod> productosBajos = dao.obtenerProductosConStockBajo();
        if (productosBajos.isEmpty()) {
            System.out.println("No hay productos con stock bajo.");
            return false;
        }

        dao.crearOrdenCompra(productosBajos);
        return true;
    }
}
