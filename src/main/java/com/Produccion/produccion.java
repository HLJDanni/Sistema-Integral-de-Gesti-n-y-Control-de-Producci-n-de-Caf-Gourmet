package com.Produccion;

//import com.Modelo.Inventario.almacen;
import com.Modelo.Inventario.articulo;
import com.Usuarios.UserDTO;
import java.time.LocalDate;
import java.util.List;

public class produccion {

    private int idProduccion;
    private int idArticulo;
    private int idAlmacenDestino;

    private articulo articulo;
    private int almacenDestino;
    private UserDTO usuario;

    private Double cantidadProducida;
    private LocalDate fechaProduccion;
    private int idEtapa;
    private int idTareasProduccion;
    private String Estado;

    private List<detalle_produccion> detalles;

    //  Constructor vacío
    public produccion() {}

    //  Constructor general (útil para crear manualmente desde DAO)
    public produccion(
        int idProduccion,
        int idArticulo,
        Double cantidadProducida,
        LocalDate fechaProduccion,
        int idAlmacenDestino
    ) {
        this.idProduccion = idProduccion;
        this.idArticulo = idArticulo;
        this.cantidadProducida = cantidadProducida;
        this.fechaProduccion = fechaProduccion;
        this.idAlmacenDestino = idAlmacenDestino;
    }

    // Getters y Setters
    public int getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdAlmacenDestino() {
        return idAlmacenDestino;
    }

    public void setIdAlmacenDestino(int idAlmacenDestino) {
        this.idAlmacenDestino = idAlmacenDestino;
    }

    public articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(articulo articulo) {
        this.articulo = articulo;
    }

    public int getAlmacenDestino() {
        return almacenDestino;
    }

    public void setAlmacenDestino(int almacenDestino) {
        this.almacenDestino = almacenDestino;
    }

    public UserDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UserDTO usuario) {
        this.usuario = usuario;
    }

    public Double getCantidadProducida() {
        return cantidadProducida;
    }

    public void setCantidadProducida(Double cantidadProducida) {
        this.cantidadProducida = cantidadProducida;
    }

    public LocalDate getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(LocalDate fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public int getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(int idEtapa) {
        this.idEtapa = idEtapa;
    }

    public int getIdTareasProduccion() {
        return idTareasProduccion;
    }

    public void setIdTareasProduccion(int idTareasProduccion) {
        this.idTareasProduccion = idTareasProduccion;
    }

    public List<detalle_produccion> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<detalle_produccion> detalles) {
        this.detalles = detalles;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
}
