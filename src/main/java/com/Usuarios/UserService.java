package com.Usuarios;

import com.coffee.coffee.Conexión.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final DbConnection db;

    public UserService(DbConnection db) {
        this.db = db;
    }

    public boolean usuarioExiste(String username) {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (Exception e) {
            System.out.println("Error al verificar usuario: " + e.getMessage());
            return false;
        }
    }

    public void registrarUsuario(String username, String password, String rol) {
        if (usuarioExiste(username)) {
            System.out.println(
                "El usuario '" + username + "' ya existe. No se puede insertar."
            );
            return;
        }

        String insert =
            "INSERT INTO users (username, password, rol) VALUES (?, ?, ?)";
        try (
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(insert)
        ) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, rol);
            stmt.executeUpdate();
            System.out.println(
                "✅ Usuario '" + username + "' registrado correctamente."
            );
        } catch (Exception e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }

    public boolean autenticarUsuario(String username, String password) {
        String query =
            "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        try (
            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (Exception e) {
            System.out.println(
                "Error al autenticar usuario: " + e.getMessage()
            );
            return false;
        }
    }
}
