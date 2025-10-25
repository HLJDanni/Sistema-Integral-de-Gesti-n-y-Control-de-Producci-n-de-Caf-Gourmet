package com.ProcesoProd;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProduccionService {

    private final ProduccionRepository produccionRepository;

    public ProduccionService(ProduccionRepository produccionRepository) {
        this.produccionRepository = produccionRepository;
    }

    public List<Produccion> listarProducciones() {
        return produccionRepository.findAll();
    }

    public Produccion iniciarProduccion(Produccion produccion) {
        return produccionRepository.save(produccion);
    }

    public Optional<Produccion> obtenerPorId(Long id) {
        return produccionRepository.findById(id);
    }

    public Produccion actualizarProduccion(
        Long id,
        Produccion produccionActualizada
    ) {
        return produccionRepository
            .findById(id)
            .map(p -> {
                p.setCantidadProducida(
                    produccionActualizada.getCantidadProducida()
                );
                p.setEtapa(produccionActualizada.getEtapa());
                p.setFecha(produccionActualizada.getFecha());
                return produccionRepository.save(p);
            })
            .orElseThrow(() ->
                new RuntimeException("Producción no encontrada")
            );
    }
}
