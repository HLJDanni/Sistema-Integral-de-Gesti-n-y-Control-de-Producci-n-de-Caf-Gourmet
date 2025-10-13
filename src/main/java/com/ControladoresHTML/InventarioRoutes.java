package com.ControladoresHTML;

package com.ControladoresHTML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.Modelo.Inventario.InventarioMod;
import com.Modelo.Inventario.inventarioDAO;

@RestController
@RequestMapping("/api/inventario")
public class InventarioRoutes {

    @Autowired
    private inventarioDAO dao;

    // Crear o actualizar inventario
    @PostMapping("/guardar")
    public boolean guardarInventario(@RequestBody InventarioMod inventario) {
        try {
            dao.actualizarInventario(inventario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener todos los inventarios
    @GetMapping("/listar")
    public List<InventarioMod> listarInventarios() {
        try {
            return dao.obtenerTodosInventarios();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Eliminar inventario
    @DeleteMapping("/eliminar/{idArticulo}")
    public boolean eliminarInventario(@PathVariable int idArticulo) {
        try {
            dao.eliminarInventario(idArticulo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
