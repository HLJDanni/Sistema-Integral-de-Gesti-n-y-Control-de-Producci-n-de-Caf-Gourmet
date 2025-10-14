import axios from "axios";

export const http = axios.create({
  baseURL: "/api",
  timeout: 10000,
  headers: { "Content-Type": "application/json" },
  // El back te devuelve texto en /login y /register:
  transformResponse: [(data, headers) => {
    const ct = headers?.getContentType?.() || headers?.["content-type"] || "";
    if (ct.includes("application/json")) {
      try { return JSON.parse(data); } catch { return data; }
    }
    return data; // texto plano
  }],
});

// (Opcional) Interceptor de errores legibles
http.interceptors.response.use(
  r => r,
  err => {
    const msg = err.response?.data || err.message || "Error de red";
    return Promise.reject(new Error(msg));
  }
);
