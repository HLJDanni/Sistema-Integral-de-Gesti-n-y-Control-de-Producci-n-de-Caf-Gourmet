# estructura del proyecto 

src/
├─ app/
│  ├─ http.js                 # Instancia de Axios (usa la baseURL de .env)
│  ├─ router.jsx              # Rutas de la app (react-router-dom)
│  └─ store.js                # (Opcional) Estado global si lo necesitas
│
├─ features/
│  ├─ auth/                   # Todo lo de autenticación (login/registro)
│  │  ├─ api/
│  │  │  └─ auth.js          # Funciones que llaman al backend (loginApi, registerApi)
│  │  ├─ components/
│  │  │  └─ LoginForm.jsx    # Formulario puro (inputs, botones)
│  │  ├─ hooks/
│  │  │  └─ useLogin.js      # Lógica del login (manejo de submit, estados, navigate)
│  │  └─ pages/
│  │     └─ Login.jsx        # Página que usa LoginForm + hook (render de la vista)
│  │
│  └─ dashboard/
│     ├─ components/
│     │  └─ Cards.jsx        # Ejemplo de componentes del dashboard
│     └─ pages/
│        └─ Dashboard.jsx    # Página del dashboard
│
├─ components/                # Componentes UI reutilizables en toda la app
│  ├─ Button.jsx
│  └─ Input.jsx
│
├─ styles/
│  ├─ variables.css           # Variables CSS (colores, fuentes)
│  ├─ globals.css             # Estilos globales (resets, body)
│  └─ README.md               # Qué estilos hay y cómo usarlos
│
├─ assets/                    # Imágenes, íconos, fuentes
│  └─ cafe-logo.png
│
├─ App.jsx                    # Monta el <Router /> y <Toaster />, y usa app/router.jsx
└─ main.jsx                   # Punto de entrada de Vite/React
