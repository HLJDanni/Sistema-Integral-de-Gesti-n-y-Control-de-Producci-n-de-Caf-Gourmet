import React, { useState, useEffect } from "react";
import { crearTipoGrano, listarTiposDeGrano } from "../../auth/api/tipo-grano";
import "./Granos.css";

export default function Granos() {
  const [granos, setGranos] = useState([]);
  const [mostrarFormulario, setMostrarFormulario] = useState(false);
  const [nuevoGrano, setNuevoGrano] = useState({
    nombre: "",
    descripcion: "",
  });

  // 🔹 Cargar lista al iniciar la página
  useEffect(() => {
    const fetchGranos = async () => {
      try {
        const data = await listarTiposDeGrano();
        setGranos(data);
      } catch (error) {
        console.error("Error al cargar granos:", error);
      }
    };
    fetchGranos();
  }, []);

  const manejarCambio = (e) => {
    const { name, value } = e.target;
    setNuevoGrano({ ...nuevoGrano, [name]: value });
  };

  const guardarGrano = async (e) => {
    e.preventDefault();

    if (!nuevoGrano.nombre || !nuevoGrano.descripcion) {
      alert("Por favor, completa todos los campos");
      return;
    }

    try {
      await crearTipoGrano(nuevoGrano);
      alert("Grano creado correctamente");
      setNuevoGrano({ nombre: "", descripcion: "" });
      setMostrarFormulario(false);

      // 🔹 Volver a leer lista actualizada del backend
      const data = await listarTiposDeGrano();
      setGranos(data);
    } catch (error) {
      console.error("Error al crear el grano:", error);
      alert("Hubo un error al guardar el grano");
    }
  };

  return (
    <div className="granos-container">
      <div className="granos-header">
        <h1>Gestión de Tipos de Grano</h1>
        <button
          className="btn-agregar"
          onClick={() => setMostrarFormulario(!mostrarFormulario)}
        >
          {mostrarFormulario ? "Cerrar formulario" : "Agregar tipo de grano"}
        </button>
      </div>

      {mostrarFormulario && (
        <form className="form-grano" onSubmit={guardarGrano}>
          <label>
            Nombre:
            <input
              type="text"
              name="nombre"
              value={nuevoGrano.nombre}
              onChange={manejarCambio}
            />
          </label>

          <label>
            Descripción:
            <textarea
              name="descripcion"
              value={nuevoGrano.descripcion}
              onChange={manejarCambio}
              rows={3}
            ></textarea>
          </label>

          <button type="submit" className="btn-guardar">
            Guardar tipo de grano
          </button>
        </form>
      )}

      <div className="lista-granos">
        {granos.length === 0 ? (
          <p>No hay tipos de grano registrados.</p>
        ) : (
          <table>
            <thead>
              <tr>
                <th>Nombre</th>
                <th>Descripción</th>
              </tr>
            </thead>
            <tbody>
              {granos.map((g) => (
                <tr key={g.id}>
                  <td>{g.nombre}</td>
                  <td>{g.descripcion}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
}
