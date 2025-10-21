import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Toaster } from "react-hot-toast";
import Login from "./features/auth/pages/Login";
import DashboardLayout from "./features/Dashboard/pages/DashboardLayout";
import Dashboard from "./features/Dashboard/pages/Dashboard";
import Granos from "./features/Dashboard/Granos/Granos";



function App() {
  return (
    <BrowserRouter>
      {/* contenedor global para los toasts */}
      <Toaster position="top-right" />
      <Routes>
        <Route path="/" element={<Login />} />
       <Route path="/dashboard/*" element={<DashboardLayout />}>
          <Route index element={<Dashboard />} />
          <Route path="Granos" element={<Granos />} />
         
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App; 
