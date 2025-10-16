package com.Modelo.Inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.coffee.coffee", "com.Modelo"})
public class test {

    public static void main(String[] args) {
        // 1️⃣ Inicia el contexto de Spring
        ApplicationContext context = SpringApplication.run(test.class, args);

        // 2️⃣ Obtén el controlador desde el contexto (ya con sus dependencias inyectadas)
        InventarioController controller = context.getBean(InventarioController.class);

        // 3️⃣ Crea objetos simulados
        articulo articulo = new articulo();
        articulo.setIdArticulo(2); 
        articulo.setNombre("Café Arábica");

        almacen almacen = new almacen();
        almacen.setIdAlmacen(4);
        almacen.setNombre("Central");

        InventarioMod inventario = new InventarioMod();
        inventario.setArticulo(articulo);
        inventario.setAlmacen(almacen);
        inventario.setCantidad(16);
        inventario.setFechaActualizacion("2025-09-17");

        // 4️⃣ Llama al método del controlador
        controller.guardarInventario(inventario);

        System.out.println("✅ TestInventario ejecutado con éxito");
    }
}
