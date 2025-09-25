package com.Modelo.Inventario;

import com.coffee.coffee.TipoGrano;

public class articulo {
    private int idArticulo;
    private String nombre;
    private TipoGrano tipoGrano; // Asociación con TipoGrano
    private String unidadMedida;    // kg, litros, unidades
   
    // Getters y setters
    public int getIdArticulo() { return idArticulo; } 
    public void setIdArticulo(int idArticulo) { this.idArticulo = idArticulo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public TipoGrano getTipoGrano() { return tipoGrano; }
    public void setTipoGrano(TipoGrano tipoGrano) { this.tipoGrano = tipoGrano; }
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }
   
}
