package com.coffee.coffee.Usuarios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO user) {
        if (userService.usuarioExiste(user.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("❌ El usuario ya existe.");
        }
        userService.registrarUsuario(user.getUsername(), user.getPassword(), user.getRol());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("✅ Usuario registrado correctamente.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO user) {
        boolean autenticado = userService.autenticarUsuario(user.getUsername(), user.getPassword());
        if (autenticado) {
            return ResponseEntity.ok("✅ Login exitoso.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("❌ Credenciales inválidas.");
        }
    }
}