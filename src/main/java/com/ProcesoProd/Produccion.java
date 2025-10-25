package com.ProcesoProd;

import com.Produccion.TareasProduccion;
import com.Usuarios.UserDTO;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "produccion")
public class Produccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproduccion;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private Double cantidadProducida;

    @ManyToOne
    @JoinColumn(name = "Articulo_idtArticulo", nullable = false)
    private com.Modelo.Inventario.articulo articulo;

    @ManyToOne
    @JoinColumn(name = "idEtapa", nullable = false)
    private Etapa etapa;

    @ManyToOne
    @JoinColumn(name = "idtareas_produccion", nullable = false)
    private TareasProduccion tareaProduccion;

    @ManyToOne
    @JoinColumn(name = "Users_idUsuario", nullable = false)
    private UserDTO usuario;

    // Getters y Setters
    public Long getIdproduccion() {
        return idproduccion;
    }

    public void setIdproduccion(Long idproduccion) {
        this.idproduccion = idproduccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCantidadProducida() {
        return cantidadProducida;
    }

    public void setCantidadProducida(Double cantidadProducida) {
        this.cantidadProducida = cantidadProducida;
    }

    public com.Modelo.Inventario.articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(com.Modelo.Inventario.articulo articulo) {
        this.articulo = articulo;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public TareasProduccion getTareaProduccion() {
        return tareaProduccion;
    }

    public void setTareaProduccion(TareasProduccion tareaProduccion) {
        this.tareaProduccion = tareaProduccion;
    }

    public UserDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UserDTO usuario) {
        this.usuario = usuario;
    }
}
