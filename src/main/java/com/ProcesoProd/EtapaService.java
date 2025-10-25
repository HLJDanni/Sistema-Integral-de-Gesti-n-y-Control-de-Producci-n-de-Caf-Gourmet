package com.ProcesoProd;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class EtapaService {

    private final EtapaRepository etapaRepository;

    public EtapaService(EtapaRepository etapaRepository) {
        this.etapaRepository = etapaRepository;
    }

    public List<Etapa> listarEtapas() {
        return etapaRepository.findAll();
    }

    public Etapa crearEtapa(Etapa etapa) {
        return etapaRepository.save(etapa);
    }
}
