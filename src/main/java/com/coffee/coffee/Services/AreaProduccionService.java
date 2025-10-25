package com.coffee.coffee.Services;

import com.Entidades.AreaProduccion;
import com.Repositories.AreaProduccionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaProduccionService {

    @Autowired
    private AreaProduccionRepository areaRepo;

    public List<AreaProduccion> listarAreas() {
        return areaRepo.findAll();
    }

    public AreaProduccion crearArea(AreaProduccion area) {
        return areaRepo.save(area);
    }

    public AreaProduccion obtenerPorId(Long id) {
        return areaRepo
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Área no encontrada"));
    }
}
