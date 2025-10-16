package com.coffee.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = {"com.coffee.coffee", "com.Modelo"})

public class CoffeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoffeeApplication.class, args);
    } 
}