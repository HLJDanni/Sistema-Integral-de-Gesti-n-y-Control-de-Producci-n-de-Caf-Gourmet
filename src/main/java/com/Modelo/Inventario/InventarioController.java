package com.Modelo.Inventario;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    public void registrarInventario(InventarioMod inventario) {
        try {
            inventarioDAO dao = new inventarioDAO();
            dao.actualizarInventario(   inventario.getIdInventario(), inventario.getCantidad());
            System.out.println("Inventario guardado o actualizado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




