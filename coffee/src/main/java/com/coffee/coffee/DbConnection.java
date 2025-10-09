package com.coffee.coffee;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DbConnection {
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;
    private int timeout;
    private int maxConnections;
    private boolean configCargada = false;

    public DbConnection() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            props.load(fis);
            this.host = props.getProperty("host");
            this.port = Integer.parseInt(props.getProperty("port"));
            this.database = props.getProperty("database");
            this.username = props.getProperty("username");
            this.password = props.getProperty("password");
            this.timeout = Integer.parseInt(props.getProperty("timeout"));
            this.maxConnections = Integer.parseInt(props.getProperty("maxConnections"));
            configCargada = true;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar el archivo de configuración: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        if (!configCargada || host == null || database == null || username == null || password == null) {
            System.out.println("Configuración incompleta. No se puede establecer conexión.");
            return null;
        }

        try {
            String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }

    public void printConfig() {
        if (!configCargada || host == null || database == null || username == null) {
            System.out.println("No se pudo establecer la configuración de conexión.");
            return;
        }

        System.out.println(" Conexión configurada correctamente:");
        
    }
}