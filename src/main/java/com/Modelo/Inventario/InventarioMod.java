
package com.Modelo.Inventario;


public class InventarioMod {
    private int idInventario;
    private articulo articulo;
    private double cantidad; // en la unidad del artículo
    private almacen almacen; // Asociación con Almacén
    private String fechaActualizacion;

    // Getters y setters
    public int getIdInventario() { return idInventario; }
    public void setIdInventario(int idInventario) { this.idInventario = idInventario; }
    public articulo getArticulo() { return articulo; }
    public void setArticulo(articulo articulo) { this.articulo = articulo; }
    public double getCantidad() { return cantidad; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }
    public almacen getAlmacen() { return almacen; }
    public void setAlmacen(almacen almacen) { this.almacen = almacen; }
    public String getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(String fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }

    
}