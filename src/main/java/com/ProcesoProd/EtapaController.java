package com.ProcesoProd;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etapas")
@CrossOrigin(origins = "*")
public class EtapaController {

    private final EtapaService etapaService;

    public EtapaController(EtapaService etapaService) {
        this.etapaService = etapaService;
    }

    @GetMapping
    public List<Etapa> listarEtapas() {
        return etapaService.listarEtapas();
    }

    @PostMapping
    public Etapa crearEtapa(@RequestBody Etapa etapa) {
        return etapaService.crearEtapa(etapa);
    }
}
