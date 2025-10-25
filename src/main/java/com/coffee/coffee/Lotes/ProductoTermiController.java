package com.coffee.coffee.Lotes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lotes")
public class ProductoTermiController {

    @Autowired
    private ProductoTermiService service;

    // 1️⃣ Registrar lote automáticamente al terminar producción
    @PostMapping("/registrar")
    public String registrarLote(@RequestBody ProductoTerminado producto) {
        service.registrarLote(producto);
        return "Lote creado correctamente en estado pendiente";
    }

    // 2️⃣ Registrar resultado del control de calidad (manual)
    @PutMapping("/control/{id}")
    public String registrarControl(@PathVariable int id, @RequestBody ProductoTerminado lote) {
        service.registrarControlCalidad(
            id,
            lote.getControlCalidad(),
            lote.getObservacion()
        );
        return "Resultado de control de calidad registrado";
    }

   // 3️⃣ Listar todos los lotes
@GetMapping("/listar")
public List<ProductoTerminado> listarLotes() {
    return service.consultarLotes(); // <-- aquí se llama al método correcto
}

}
