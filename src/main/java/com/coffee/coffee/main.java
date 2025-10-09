package com.coffee.coffee;
import java.sql.Connection;


public class main {
    public static void main(String[] args) {
        System.out.println("Probando conexión a la base de datos...");
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getConnection();
        if (connection != null) {
            System.out.println("Conexión exitosa a la base de datos.");
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }
}
