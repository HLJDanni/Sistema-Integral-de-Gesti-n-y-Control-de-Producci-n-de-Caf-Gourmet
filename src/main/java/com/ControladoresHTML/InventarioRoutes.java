package com.ControladoresHTML;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import java.util.List;

import com.Modelo.Inventario.InventarioMod;
import com.Modelo.Inventario.inventarioDAO;

@RestController
@RequestMapping("/api/inventario")
public class InventarioRoutes {

    @Autowired
    private inventarioDAO dao;

    //  Crear un nuevo registro de inventario
    @PostMapping("/crear")
    public boolean crearInventario(@RequestBody InventarioMod inventario) {
        try {
            dao.insertarInventario(inventario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

     @GetMapping("/listar")
public List<InventarioMod> listarInventario() {
    try {
        return dao.listarInventario();
    } catch (Exception e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}
       
    @GetMapping("/consultar/{idAlmacen}/{idArticulo}")
public Double consultarInventario(@PathVariable int idAlmacen, @PathVariable int idArticulo) {
    try {
        return dao.consultarInventario(idArticulo, idAlmacen);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

    //  Actualizar inventario existente
    @PutMapping("/actualizar")
    public boolean actualizarInventario(@RequestBody InventarioMod inventario) {
        try {
            dao.actualizarInventario(
                inventario.getArticulo(),
                inventario.getAlmacen(),
                inventario.getCantidad()
            );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //  Eliminar inventario (por id del artículo y almacén)
    @DeleteMapping("/eliminar")
    public boolean eliminarInventario(@RequestBody InventarioMod inventario) {
        try {
            dao.eliminarInventario(inventario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
