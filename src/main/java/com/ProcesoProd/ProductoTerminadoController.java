package com.ProcesoProd;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producto-terminado")
@CrossOrigin(origins = "*")
public class ProductoTerminadoController {

    private final ProductoTerminadoService productoTerminadoService;

    public ProductoTerminadoController(
        ProductoTerminadoService productoTerminadoService
    ) {
        this.productoTerminadoService = productoTerminadoService;
    }

    @GetMapping
    public List<ProdTerminado> listarProductosTerminados() {
        return productoTerminadoService.listarProductosTerminados();
    }

    @PostMapping
    public ProdTerminado registrarProductoTerminado(
        @RequestBody ProdTerminado productoTerminado
    ) {
        return productoTerminadoService.registrarProductoTerminado(
            productoTerminado
        );
    }
}
