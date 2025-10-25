package com.coffee.coffee.Services;

import com.Entidades.AreaProduccion;
import com.Entidades.TareaProduccion;
import com.Repositories.AreaProduccionRepository;
import com.Repositories.TareaProduccionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaProduccionService {

    @Autowired
    private TareaProduccionRepository tareaRepo;

    @Autowired
    private AreaProduccionRepository areaRepo;

    public TareaProduccion guardarTarea(TareaProduccion tarea) {
        return tareaRepo.save(tarea);
    }

    public List<TareaProduccion> listarTareas() {
        return tareaRepo.findAll();
    }

    public TareaProduccion actualizarEstado(Long id, String nuevoEstado) {
        TareaProduccion tarea = tareaRepo
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        tarea.setEstado(nuevoEstado);
        return tareaRepo.save(tarea);
    }

    public TareaProduccion asignarTarea(Long areaId, TareaProduccion tarea) {
        AreaProduccion area = areaRepo
            .findById(areaId)
            .orElseThrow(() -> new RuntimeException("Área no encontrada"));
        tarea.setAreaProduccion(area);
        tarea.setEstado("Pendiente");
        return tareaRepo.save(tarea);
    }

    public List<TareaProduccion> listarPorArea(Long areaId) {
        return tareaRepo.findByAreaProduccionId(areaId);
    }
}
