package com.coffee.coffee.Lotes;

import java.time.LocalDate;

import com.Produccion.produccion;


public class ProductoTerminado {
    private int idproductoTerminado;
    private LocalDate fechaTerminado;
    private LocalDate fechaVencimiento;
    private Double cantidad;
    private String Estado;
    private String observacion;
    private produccion produccion;
    private String controlCalidad;

    public ProductoTerminado() {
    }

    // Getters y Setters
    public int getIdProductoTerminado() {
        return idproductoTerminado;
    }
    public void setIdProductoTerminado(int idproductoTerminado) {
        this.idproductoTerminado = idproductoTerminado;
    }
    public LocalDate getFechaTerminado() {
        return fechaTerminado;
    }
    public void setFechaTerminado(LocalDate fechaTerminado) {
        this.fechaTerminado = fechaTerminado;
    }
    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public Double getCantidad(){
        return cantidad;
    }
    public void setcantidad(Double cantidad){
        this.cantidad = cantidad;
    }
    public String getEstado() {
        return Estado;
    }   
    public void setEstado(String estado) {
        Estado = estado;
    }   
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public produccion getProduccion() {
        return produccion;
    }
    public void setProduccion(produccion produccion) {
        this.produccion = produccion;
    }   
    public String getControlCalidad() {
        return controlCalidad;
    }
    public void setControlCalidad(String controlCalidad) {
        this.controlCalidad = controlCalidad;
    }
}
