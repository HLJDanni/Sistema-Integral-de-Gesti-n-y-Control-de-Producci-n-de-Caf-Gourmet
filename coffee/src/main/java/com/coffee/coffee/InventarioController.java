package com.coffee.coffee;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private InventarioService service = new InventarioService();

    @PostMapping("/generar-orden")
    public String generarOrden() {
        boolean creada = service.generarOrdenSiStockBajo();

        if (creada) {
            return "✅ Orden de compra generada correctamente.";
        } else {
            return "ℹ️ No hay productos con stock bajo.";
        }
    }
}
