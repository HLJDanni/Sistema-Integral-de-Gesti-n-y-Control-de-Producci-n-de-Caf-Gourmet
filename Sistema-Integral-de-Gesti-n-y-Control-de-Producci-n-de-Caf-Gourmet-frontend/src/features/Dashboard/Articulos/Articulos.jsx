import React, { useState } from "react";
import { useArticulos } from "./useArticulos";
import "./Articulos.css";

export default function Articulos() {
  const { articulos, loading, error, agregarArticulo, editarArticulo, borrarArticulo, recargar } = useArticulos();
  const [mostrarFormulario, setMostrarFormulario] = useState(false);
  const [modoEdicion, setModoEdicion] = useState(false);
  const [articuloActual, setArticuloActual] = useState(null);
  const [formData, setFormData] = useState({
    nombre: "",
    descripcion: "",
    tipoGrano: { id: "" },
  });

  const manejarCambio = (e) => {
    const { name, value } = e.target;
    if (name === "tipoGrano.id") {
      setFormData({ ...formData, tipoGrano: { id: value } });
    } else {
      setFormData({ ...formData, [name]: value });
    }
  };

  const guardar = async (e) => {
    e.preventDefault();
    if (!formData.nombre || !formData.descripcion || !formData.tipoGrano.id) {
      alert("Por favor, completa todos los campos.");
      return;
    }
    if (modoEdicion) {
      await editarArticulo(articuloActual.idArticulo, formData);
      alert("Artículo actualizado correctamente");
    } else {
      await agregarArticulo(formData);
      alert("Artículo creado correctamente");
    }
    setMostrarFormulario(false);
    setModoEdicion(false);
    setFormData({ nombre: "", descripcion: "", tipoGrano: { id: "" } });
  };

  const iniciarEdicion = (art) => {
    setModoEdicion(true);
    setMostrarFormulario(true);
    setArticuloActual(art);
    setFormData({
      nombre: art.nombre,
      descripcion: art.descripcion,
      tipoGrano: { id: art.tipoGrano.id },
    });
  };

  return (
    <div className="articulos-container">
      <div className="articulos-header">
        <h1>Gestión de Granos</h1>
        <div className="articulos-header-buttons">
          <button
            className="btn-agregar"
            onClick={() => {
              setMostrarFormulario(!mostrarFormulario);
              setModoEdicion(false);
              setFormData({ nombre: "", descripcion: "", tipoGrano: { id: "" } });
            }}
          >
            {mostrarFormulario ? "Cerrar formulario" : "Agregar Grano"}
          </button>
          <button className="btn-actualizar" onClick={recargar}>
            Actualizar lista
          </button>
        </div>
      </div>

      {mostrarFormulario && (
        <form className="form-articulo" onSubmit={guardar}>
          <h2>{modoEdicion ? "Editar Artículo" : "Nuevo Artículo"}</h2>
          <label>
            Nombre:
            <input type="text" name="nombre" value={formData.nombre} onChange={manejarCambio} />
          </label>
          <label>
            Descripción:
            <input type="text" name="descripcion" value={formData.descripcion} onChange={manejarCambio} />
          </label>
          <label>
            ID Tipo Grano:
            <input type="number" name="tipoGrano.id" value={formData.tipoGrano.id} onChange={manejarCambio} />
          </label>
          <button type="submit" className="btn-guardar">
            {modoEdicion ? "Actualizar" : "Guardar"}
          </button>
        </form>
      )}

      {loading ? (
        <p>Cargando artículos...</p>
      ) : error ? (
        <p style={{ color: "red" }}>{error}</p>
      ) : articulos.length === 0 ? (
        <p>No hay Granos registrados.</p>
      ) : (
        <div className="lista-articulos">
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Descripción</th>
                <th>ID Tipo Grano</th>
                <th>Acciones</th>
              </tr>
            </thead>
            <tbody>
              {articulos.map((a) => (
                <tr key={a.idArticulo}>
                  <td>{a.idArticulo}</td>
                  <td>{a.nombre}</td>
                  <td>{a.descripcion}</td>
                  <td>{a.tipoGrano?.id}</td>
                  <td className="acciones">
                    <button className="btn-editar" onClick={() => iniciarEdicion(a)}>Editar</button>
                    <button className="btn-eliminar" onClick={() => borrarArticulo(a.idArticulo)}>Eliminar</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}
