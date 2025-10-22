package com.Produccion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/produccion")

public class ProduccionController {
    
    private final produccionService service;

    public ProduccionController(produccionService service) {
        this.service = service;
    }

    @PostMapping("/guardar")
public ResponseEntity<String> guardarProduccion(@RequestBody produccion produccion) {
    try {
        service.guardarProduccion(produccion);
        return ResponseEntity.ok("Producción guardada correctamente");
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Error al guardar la producción: " + e.getMessage());
    }
}

    @PutMapping("/Actualizar")
    public ResponseEntity<String> actualizarProduccion(@RequestBody produccion produccion) {
        try {
            service.actualizarProduccion(produccion);
            return ResponseEntity.ok("Producción actualizada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al actualizar la producción: " + e.getMessage());
        }
    }
    

}



  
    

