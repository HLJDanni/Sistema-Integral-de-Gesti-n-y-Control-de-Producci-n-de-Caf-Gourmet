package com.Entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "areas_produccion")
public class AreaProduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre; // Ej: "Tostado", "Molienda", "Empaque"

    private String descripcion;

    @OneToMany(
        mappedBy = "areaProduccion",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<TareaProduccion> tareas;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<TareaProduccion> getTareas() {
        return tareas;
    }

    public void setTareas(List<TareaProduccion> tareas) {
        this.tareas = tareas;
    }
}
