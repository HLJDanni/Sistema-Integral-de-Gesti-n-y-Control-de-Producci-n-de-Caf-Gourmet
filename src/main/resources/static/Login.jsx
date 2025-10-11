import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import logo from '../assets/Cafe Gorumet logo.png'
import './Login.css'

function Login() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const navigate = useNavigate()

  const handleSubmit = (e) => {
    e.preventDefault()
    // Any username/password works
    navigate('/dashboard')
  }

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
            <form onSubmit={handleSubmit}>
              <div className="login-form-group">
                <input
                  type="text"
                  placeholder="Email"
                  className="login-input"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
              </div>
              <div className="login-form-group">
                <input
                  type="password"
                  placeholder="Password"
                  className="login-input"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
              </div>
              <div className="login-button-container">
                <button
                  type="submit"
                  className="login-button"
                >
                  Log In
                </button>
              </div>
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

