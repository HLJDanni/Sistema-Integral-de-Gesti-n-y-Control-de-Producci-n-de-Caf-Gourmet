package com.coffee.coffee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // Busca login.html en /resources/templates
    }

    @GetMapping("/register")
    public String mostrarRegistro() {
        return "register"; // Busca register.html en /resources/templates
    }
}