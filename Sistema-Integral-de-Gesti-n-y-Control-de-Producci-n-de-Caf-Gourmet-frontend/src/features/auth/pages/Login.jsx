import React, { useState } from 'react'
import { useNavigate } from "react-router-dom";

import logo from '../../assets/Cafe Gorumet logo.png'
import './Login.css'
import toast from "react-hot-toast";
import { loginApi } from "../api/auth";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading]   = useState(false);
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    try {
      await loginApi({ username, password });  // 200 => OK
      toast.success("Login exitoso ✅");
      navigate("/dashboard");                  // << redirección
    } catch (err) {
      // 401 u otros errores
      const msg = err?.response?.data || "Credenciales inválidas";
      toast.error(typeof msg === "string" ? msg : "Credenciales inválidas");
    } finally {
      setLoading(false);
    }
  };
  return (
    <div className="login-container">
      <div className="text-xl md:w-1/2 mx-auto">
        <div className="login-card">
          <div className="login-content">
            <div className="login-logo-container">
              <img
                src={logo}
                alt="Cafe Gourmet Logo"
                className="login-logo"
              />
            </div>
            <h1 className="login-title">Login</h1>
    <form onSubmit={handleSubmit} className="login-form">
      <input
        value={username}
        onChange={(e) => setUsername(e.target.value)}
        placeholder="Usuario"
      />
      <input
        type="password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
        placeholder="Contraseña"
      />
      <button disabled={loading}>
        {loading ? "Ingresando..." : "Ingresar"}
      </button>
    </form>
            <p className="login-disclaimer">
              All data will be saved at our own private database and will not be
              shared with any third party entity
            </p>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Login

