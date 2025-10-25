package com.Entidades;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tareas_produccion")
public class TareaProduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreTarea;
    private String descripcion;
    private LocalDate fechaAsignacion;
    private LocalDate fechaEntrega;
    private String estado; // Pendiente, En proceso, Completada

    @ManyToOne
    @JoinColumn(name = "area_id")
    private AreaProduccion areaProduccion;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public AreaProduccion getAreaProduccion() {
        return areaProduccion;
    }

    public void setAreaProduccion(AreaProduccion areaProduccion) {
        this.areaProduccion = areaProduccion;
    }
}
