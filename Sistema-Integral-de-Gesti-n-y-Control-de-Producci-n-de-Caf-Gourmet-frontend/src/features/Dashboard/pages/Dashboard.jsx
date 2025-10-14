import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import logo from '../../assets/Cafe Gorumet logo.png'
import './Dashboard.css'

const NAV = [
  { key: 'dashboard', label: 'Dashboard' },
  { key: 'productos', label: 'Productos' },
  { key: 'inventarios', label: 'Inventarios' },
  { key: 'ventas', label: 'Ventas' },
  { key: 'clientes', label: 'Clientes' },
  { key: 'reportes', label: 'Reportes' },
  { key: 'logout', label: 'Log out' }
]

export default function Dashboard() {
  const [active, setActive] = useState('dashboard')
  const navigate = useNavigate()

  const onClick = (key) => {
    setActive(key)
    if (key === 'logout') return navigate('/')
    // aquí enruta a tus vistas reales
    // navigate(`/${key}`)
  }

  return (
    <div className="dl-root">
      {/* Sidebar tipo tarjeta */}
      <aside className="dl-aside">
        <div className="dl-card">
          <div className="dl-brand">
            <img src={logo} alt="CafeGourmet" />
          </div>

          <nav className="dl-nav">
            {NAV.map((item) => (
              <button
                key={item.key}
                className={`dl-nav-item ${active === item.key ? 'is-active' : ''}`}
                onClick={() => onClick(item.key)}
              >
                <span className="dot" aria-hidden />
                <span>{item.label}</span>
              </button>
            ))}
          </nav>
        </div>
      </aside>

      {/* Contenido principal */}
      <main className="dl-main">
        <div className="dl-placeholder">
          <h1>{NAV.find(n => n.key === active)?.label}</h1>
          <p>Pantalla en construcción (usa este layout como base).</p>
        </div>
      </main>
    </div>
  )
}
