package com.ProcesoProd;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produccion")
@CrossOrigin(origins = "*")
public class ProduccionController {

    private final ProduccionService produccionService;

    public ProduccionController(ProduccionService produccionService) {
        this.produccionService = produccionService;
    }

    @GetMapping
    public List<Produccion> listarProducciones() {
        return produccionService.listarProducciones();
    }

    @PostMapping("/iniciar")
    public Produccion iniciarProduccion(@RequestBody Produccion produccion) {
        return produccionService.iniciarProduccion(produccion);
    }

    @PutMapping("/{id}/finalizar")
    public Produccion finalizarProduccion(
        @PathVariable Long id,
        @RequestBody Produccion produccion
    ) {
        return produccionService.actualizarProduccion(id, produccion);
    }
}
