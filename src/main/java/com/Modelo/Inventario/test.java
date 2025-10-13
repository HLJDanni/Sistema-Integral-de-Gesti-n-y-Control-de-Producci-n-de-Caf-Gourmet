package com.Modelo.Inventario;

import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.coffee.coffee.CoffeeApplication;

import org.springframework.boot.SpringApplication;

//import com.Modelo.Inventario.inventarioDAO;
//import com.Controlador.Inventario.InventarioController;
//import com.Modelo.Inventario.articulo;
//import Java.util.Scanner;

@SpringBootApplication
public class test {
public static void main(String[] args) {
        SpringApplication.run(test.class, args);
        // 1️ Crear un artículo simulado
        articulo articulo = new articulo();
        articulo.setIdArticulo(2); 
        articulo.setNombre("Café Arábica");

        // 2️ Asignar un almacén simulado
        almacen almacen = new almacen();
        almacen.setIdAlmacen(1);
        almacen.setNombre("Central");

        // Creamos el inventario
        InventarioMod inventario = new InventarioMod();
        inventario.setArticulo(articulo);
        inventario.setCantidad(20);
        inventario.setFechaActualizacion("2025-09-17");

        // Pasamos por el controlador
        InventarioController controller = new InventarioController();
        controller.registrarInventario(inventario);

        System.out.println("✅ TestInventario ejecutado con éxito");
    }
    
}
