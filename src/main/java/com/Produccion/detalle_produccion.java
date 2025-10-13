package com.Produccion;

public class detalle_produccion {       
    private int idDetalleProduccion;
    private produccion produccion;
    private articulo articulo;
    private int cantidadUtilizada;

    // Constructor
    public detalle_produccion(int idDetalleProduccion, produccion produccion, articulo articulo, int cantidadUtilizada) {
        this.idDetalleProduccion = idDetalleProduccion;
        this.produccion = produccion;
        this.articulo = articulo;
        this.cantidadUtilizada = cantidadUtilizada;
    }

    // Getters y Setters
    public int getIdDetalleProduccion() {
        return idDetalleProduccion;
    }

    public void setIdDetalleProduccion(int idDetalleProduccion) {
        this.idDetalleProduccion = idDetalleProduccion;
    }

    public produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(produccion produccion) {
        this.produccion = produccion;
    }

    public articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public void setCantidadUtilizada(int cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }
    
}
