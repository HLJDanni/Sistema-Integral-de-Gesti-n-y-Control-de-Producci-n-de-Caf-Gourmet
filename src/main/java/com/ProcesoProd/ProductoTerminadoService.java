package com.ProcesoProd;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductoTerminadoService {

    private final ProductoTerminadoRepository productoTerminadoRepository;

    public ProductoTerminadoService(
        ProductoTerminadoRepository productoTerminadoRepository
    ) {
        this.productoTerminadoRepository = productoTerminadoRepository;
    }

    public List<ProdTerminado> listarProductosTerminados() {
        return productoTerminadoRepository.findAll();
    }

    public ProdTerminado registrarProductoTerminado(
        ProdTerminado productoTerminado
    ) {
        return productoTerminadoRepository.save(productoTerminado);
    }
}
