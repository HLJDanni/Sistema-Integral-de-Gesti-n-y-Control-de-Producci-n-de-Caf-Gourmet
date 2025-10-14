import { useState } from "react";
import { loginApi } from "../api/auth";

export function useLogin() {
  const [loading, setLoading] = useState(false);
  const [error, setError]     = useState(null);
  const [message, setMessage] = useState(null);

  const login = async (form) => {
    setLoading(true);
    setError(null);
    setMessage(null);
    try {
      const data = await loginApi(form); // texto: "✅ Login exitoso."
      setMessage(typeof data === "string" ? data : "Login exitoso");
      // aquí podrías navegar al dashboard o guardar algo en estado global
      return true;
    } catch (e) {
      setError(e.message || "Error al iniciar sesión");
      return false;
    } finally {
      setLoading(false);
    }
  };

  return { login, loading, error, message };
}
