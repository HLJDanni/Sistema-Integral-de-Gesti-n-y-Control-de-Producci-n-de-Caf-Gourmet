package com.coffee.coffee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class UserService {

    private final DbConnection db;

    public UserService(DbConnection db) {
        this.db = db;
    }

    public boolean usuarioExiste(String username) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;

        } catch (Exception e) {
            System.out.println("Error al verificar usuario: " + e.getMessage());
            return false;
        }
    }

    public void registrarUsuario(String username, String password, String propietario) {
        if (usuarioExiste(username)) {
            System.out.println("El usuario '" + username + "' ya existe. No se puede insertar.");
            return;
        }

        String insert = "INSERT INTO users (username, password, propietario) VALUES (?, ?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insert)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, propietario);
            stmt.executeUpdate();
            System.out.println("✅ Usuario '" + username + "' registrado correctamente.");

        } catch (Exception e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }
}