package com.Controllers;

import com.Entidades.AreaProduccion;
import com.coffee.coffee.Services.AreaProduccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/areas")
public class AreaProduccionController {

    @Autowired
    private AreaProduccionService areaService;

    @GetMapping
    public List<AreaProduccion> listarAreas() {
        return areaService.listarAreas();
    }

    @PostMapping
    public AreaProduccion crearArea(@RequestBody AreaProduccion area) {
        return areaService.crearArea(area);
    }

    @GetMapping("/{id}")
    public AreaProduccion obtenerAreaPorId(@PathVariable Long id) {
        return areaService.obtenerPorId(id);
    }
}
