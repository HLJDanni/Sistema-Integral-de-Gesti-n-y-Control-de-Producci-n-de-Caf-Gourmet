package com.ControladoresHTML;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class htmlController {

    @GetMapping("/")
    public String mostrarLogin() {
        return "index"; // Busca login.html en /resources/templates
    }

    @GetMapping("/register")
    public String mostrarRegistro() {
        return "register"; // Busca register.html en /resources/templates
    }
}