package com.Controllers;

import com.Modelo.Inventario.InventarioMod;
import com.Modelo.Inventario.InventarioService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final InventarioService service;

    //@Autowired
    public InventarioController(InventarioService service) {
        this.service = service;
    }

    // Guardar o actualizar inventario
    @PostMapping("/guardar")
    public String guardarInventario(@RequestBody InventarioMod inventario) {
        service.guardarInventario(inventario);
        return "Inventario procesado correctamente";
    }

    // Eliminar inventario
    @DeleteMapping("/eliminar")
    public String eliminarInventario(@RequestBody InventarioMod inventario) {
        service.eliminarInventario(inventario);
        return "Inventario eliminado correctamente";
    }
}
