package com.Produccion;

public class produccion {
    private int idProduccion;
    private articulo articulo;
    private int cantidadProducida;
    private String fechaProduccion;
    private almacen almacenDestino;

    // Constructor
    public produccion(int idProduccion, articulo articulo, int cantidadProducida, String fechaProduccion, almacen almacenDestino) {
        this.idProduccion = idProduccion;
        this.articulo = articulo;
        this.cantidadProducida = cantidadProducida;
        this.fechaProduccion = fechaProduccion;
        this.almacenDestino = almacenDestino;
    }

    // Getters y Setters
    public int getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidadProducida() {
        return cantidadProducida;
    }

    public void setCantidadProducida(int cantidadProducida) {
        this.cantidadProducida = cantidadProducida;
    }

    public String getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(String fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public almacen getAlmacenDestino() {
        return almacenDestino;
    }

    public void setAlmacenDestino(almacen almacenDestino) {
        this.almacenDestino = almacenDestino;
    }
    
}
