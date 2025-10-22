package com.coffee.coffee.Monitores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PowerBIControllerAvance_Produccion {

    // URL del panel de Power BI (La URL va a cambiar cuando se terminen de hacer los págnes y estén publicados)
    private static final String POWER_BI_URL =
        "https://app.powerbi.com/view?r=TU_ID_DE_REPORTE";

    @GetMapping("/panelAvanceProd/powerbi")
    public String getPowerBILink() {
        // Retorna el enlace como HTML simple (Se puede usar JSON si uno quiere)
        return (
            "<a href=\"" +
            POWER_BI_URL +
            "\" target=\"_blank\">Abrir Panel Power BI</a>"
        );
    }
}
