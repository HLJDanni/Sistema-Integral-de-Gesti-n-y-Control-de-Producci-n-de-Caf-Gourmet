package com.Controllers;

import com.Entidades.TareaProduccion;
import com.coffee.coffee.Services.TareaProduccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tareas")
public class TareaProduccionController {

    @Autowired
    private TareaProduccionService tareaService;

    @PostMapping
    public TareaProduccion crearTarea(@RequestBody TareaProduccion tarea) {
        return tareaService.guardarTarea(tarea);
    }

    @PostMapping("/asignar/{areaId}")
    public TareaProduccion asignarTarea(
        @PathVariable Long areaId,
        @RequestBody TareaProduccion tarea
    ) {
        return tareaService.asignarTarea(areaId, tarea);
    }

    @PutMapping("/{id}/estado")
    public TareaProduccion actualizarEstado(
        @PathVariable Long id,
        @RequestBody String nuevoEstado
    ) {
        return tareaService.actualizarEstado(id, nuevoEstado);
    }

    @GetMapping
    public List<TareaProduccion> listarTareas() {
        return tareaService.listarTareas();
    }

    @GetMapping("/area/{areaId}")
    public List<TareaProduccion> listarPorArea(@PathVariable Long areaId) {
        return tareaService.listarPorArea(areaId);
    }
}
