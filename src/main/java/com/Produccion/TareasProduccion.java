package com.Produccion;

public class TareasProduccion {
    private int idtareas_produccion;
    private String descripcion;
    private String fecha_asignacion;
    private String fecha_final;
    private String estado;
    private String tipo_produccion;
    private int idUsuario;

    // Constructor vacío
    public TareasProduccion() {}

    // Constructor completo
    public TareasProduccion(int idtareas_produccion, String descripcion, String fecha_asignacion,
                            String fecha_final, String estado, String tipo_produccion, int idUsuario) {
        this.idtareas_produccion = idtareas_produccion;
        this.descripcion = descripcion;
        this.fecha_asignacion = fecha_asignacion;
        this.fecha_final = fecha_final;
        this.estado = estado;
        this.tipo_produccion = tipo_produccion;
        this.idUsuario = idUsuario;
    }

    // Getters y Setters
    public int getIdtareas_produccion() { return idtareas_produccion; }
    public void setIdtareas_produccion(int idtareas_produccion) { this.idtareas_produccion = idtareas_produccion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getFecha_asignacion() { return fecha_asignacion; }
    public void setFecha_asignacion(String fecha_asignacion) { this.fecha_asignacion = fecha_asignacion; }

    public String getFecha_final() { return fecha_final; }
    public void setFecha_final(String fecha_final) { this.fecha_final = fecha_final; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getTipo_produccion() { return tipo_produccion; }
    public void setTipo_produccion(String tipo_produccion) { this.tipo_produccion = tipo_produccion; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
}
