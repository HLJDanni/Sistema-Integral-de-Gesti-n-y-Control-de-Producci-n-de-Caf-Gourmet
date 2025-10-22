package com.Produccion;
import java.util.List;

public class TareasProduccionService {

    private TareasProduccionDAO dao = new TareasProduccionDAO();

    public List<TareasProduccion> obtenerTodas() {
        return dao.listarTareas();
    }

    public boolean agregarTarea(TareasProduccion tarea) {
        return dao.insertarTarea(tarea);
    }

    public boolean actualizarTarea(TareasProduccion tarea) {
        return dao.actualizarTarea(tarea);
    }

    public boolean eliminarTarea(int id) {
        return dao.eliminarTarea(id);
    }
}
