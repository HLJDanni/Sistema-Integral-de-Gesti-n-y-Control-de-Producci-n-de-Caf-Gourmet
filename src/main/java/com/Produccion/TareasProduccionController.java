package com.Produccion;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*")

public class TareasProduccionController {

    private TareasProduccionService service = new TareasProduccionService();

    @GetMapping
    public List<TareasProduccion> listar() {
        return service.obtenerTodas();
    }

    @PostMapping
    public boolean crear(@RequestBody TareasProduccion tarea) {
        return service.agregarTarea(tarea);
    }

    @PutMapping("/{id}")
    public boolean actualizar(@PathVariable int id, @RequestBody TareasProduccion tarea) {
        tarea.setIdtareas_produccion(id);
        return service.actualizarTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable int id) {
        return service.eliminarTarea(id);
    }
}
