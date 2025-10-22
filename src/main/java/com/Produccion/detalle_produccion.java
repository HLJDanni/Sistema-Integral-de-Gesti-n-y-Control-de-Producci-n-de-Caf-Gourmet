package com.Produccion;

import com.Modelo.Inventario.almacen;
import com.Modelo.Inventario.articulo;

public class detalle_produccion {

    private int idDetalleProduccion;
    private int produccionId;       // ID de la producción (FK)
    private int articuloId;         // ID del artículo (FK)
    private int almacenId;          // ID del almacén (FK)
    private int cantidadConsumida;  // cantidad usada
    private int numeroLinea;        

   
    private produccion produccion;
    private articulo articulo;
    private almacen almacen;

    // Constructor vacío
    public detalle_produccion() {}

    // Constructor general
    public detalle_produccion(int produccionId, int articuloId, int almacenId, int cantidadConsumida) {
        this.produccionId = produccionId;
        this.articuloId = articuloId;
        this.almacenId = almacenId;
        this.cantidadConsumida = cantidadConsumida;
    }

    // Getters y Setters
    public int getIdDetalleProduccion() {
        return idDetalleProduccion;
    }

    public void setIdDetalleProduccion(int idDetalleProduccion) {
        this.idDetalleProduccion = idDetalleProduccion;
    }

    public int getProduccionId() {
        return produccionId;
    }

    public void setProduccion(int produccionId) {
        this.produccionId = produccionId;
    }

    public int getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(int articuloId) {
        this.articuloId = articuloId;
    }

    public int getAlmacenId() {
        return almacenId;
    }

    public void setAlmacenId(int almacenId) {
        this.almacenId = almacenId;
    }

    public int getCantidadConsumida() {
        return cantidadConsumida;
    }

    public void setCantidadConsumida(int cantidadConsumida) {
        this.cantidadConsumida = cantidadConsumida;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
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

    public almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(almacen almacen) {
        this.almacen = almacen;
    }
}
