import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Toaster } from "react-hot-toast";
import Login from "./features/auth/Login/Login";
import Dashboard from "./features/Dashboard/pages/Dashboard";



function App() {
  return (
    <BrowserRouter>
      {/* contenedor global para los toasts */}
      <Toaster position="top-right" />
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/dashboard" element={<Dashboard />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App; 