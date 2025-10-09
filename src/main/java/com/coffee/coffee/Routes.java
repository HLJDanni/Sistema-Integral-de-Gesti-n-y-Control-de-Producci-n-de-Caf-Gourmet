package com.coffee.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@RestController
@RequestMapping("/api/tipo-grano")
public class Routes {

    @Autowired
    private GestionMP_GranosVerdesAdd gestionGrano;

    // CREATE
    @PostMapping("/crear")
    public boolean crearTipoGrano(@RequestBody TipoGranoRequest request) {
        return gestionGrano.agregarTipoGrano(request.getNombre(), request.getDescripcion());
    }

    // READ
    @GetMapping("/listar")
    public List<TipoGrano> listarTiposDeGrano() {
        return gestionGrano.obtenerTodos();
    }

    // UPDATE
    @PutMapping("/actualizar/{id}")
    public boolean actualizarTipoGrano(@PathVariable int id, @RequestBody TipoGranoRequest request) {
        return gestionGrano.actualizarTipoGrano(id, request.getNombre(), request.getDescripcion());
    }

    // DELETE
    @DeleteMapping("/eliminar/{id}")
    public boolean eliminarTipoGrano(@PathVariable int id) {
        return gestionGrano.eliminarTipoGrano(id);
    }

    





}

