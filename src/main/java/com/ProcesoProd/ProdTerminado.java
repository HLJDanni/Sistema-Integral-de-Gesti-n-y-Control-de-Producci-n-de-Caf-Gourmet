package com.ProcesoProd;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "producto_terminado")
public class ProdTerminado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproductoTerminado;

    @Temporal(TemporalType.DATE)
    private Date fechaTermino;

    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    private Double cantidad;
    private String estado;
    private String observaciones;
    private String controlCalidad;

    @ManyToOne
    @JoinColumn(name = "idproduccion", nullable = false)
    private Produccion produccion;

    // Getters y Setters
    public Long getIdproductoTerminado() {
        return idproductoTerminado;
    }

    public void setIdproductoTerminado(Long idproductoTerminado) {
        this.idproductoTerminado = idproductoTerminado;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public String getControlCalidad() {
        return controlCalidad;
    }

    public void setControlCalidad(String controlCalidad) {
        this.controlCalidad = controlCalidad;
    }
}
