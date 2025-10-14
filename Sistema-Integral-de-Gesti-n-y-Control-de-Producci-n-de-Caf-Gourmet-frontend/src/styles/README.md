# Sistema de Estilos Modular

## 📁 Estructura de Archivos

```
src/
├── styles/
│   ├── variables.css      # Variables CSS globales
│   └── README.md          # Esta documentación
├── index.css              # Estilos globales y Tailwind
└── components/
    └── [Componente]/
        ├── [Componente].jsx
        └── [Componente].css    # Estilos específicos del componente
```

## 🎨 Variables CSS Globales (`variables.css`)

Contiene todas las variables CSS personalizadas para:
- **Colores**: Tema principal, secundario, acentos
- **Sombras**: Diferentes niveles de sombra
- **Espaciado**: Sistema de espaciado consistente
- **Tipografía**: Tamaños y pesos de fuente
- **Radio de borde**: Bordes redondeados

### Uso:
```css
.my-element {
  color: var(--color-primary);
  padding: var(--space-4);
  border-radius: var(--radius-md);
}
```

## 🧩 Estilos de Componentes

Cada componente tiene su propio archivo CSS:
- **Ubicación**: `src/components/[Componente]/[Componente].css`
- **Importación**: `import './[Componente].css'` en el archivo JSX
- **Alcance**: Estilos específicos del componente

### Ejemplo:
```jsx
// Login.jsx
import React from 'react'
import './Login.css'

function Login() {
  return (
    <div className="login-container">
      {/* Contenido */}
    </div>
  )
}
```

## 🎯 Mejores Prácticas

### 1. **Usa Variables CSS**
```css
/* ✅ Bueno */
.my-button {
  background-color: var(--color-primary);
  padding: var(--space-3);
}

/* ❌ Evita */
.my-button {
  background-color: #8EB486;
  padding: 0.75rem;
}
```

### 2. **Nombres de Clases Descriptivos**
```css
/* ✅ Bueno */
.login-form-group
.login-submit-button
.dashboard-header

/* ❌ Evita */
.group1
.btn1
.header
```

### 3. **Estructura Modular**
```css
/* Agrupa estilos relacionados */
.login-container { /* Contenedor principal */ }
.login-card { /* Card del formulario */ }
.login-input { /* Inputs */ }
.login-button { /* Botón */ }
```

## 🚀 Beneficios

- **Mantenibilidad**: Fácil de actualizar estilos
- **Reutilización**: Variables y clases reutilizables
- **Performance**: CSS modular carga solo lo necesario
- **Escalabilidad**: Fácil agregar nuevos componentes
- **Consistencia**: Sistema de diseño unificado

## 📝 Convenciones

- **Archivos CSS**: `PascalCase` (Login.css, Dashboard.css)
- **Clases CSS**: `kebab-case` (login-container, form-group)
- **Variables CSS**: `kebab-case` (--color-primary, --space-4)
- **Comentarios**: Documenta secciones importantes

## 🔧 Herramientas Recomendadas

- **TailwindCSS**: Para utilidades rápidas
- **CSS Modules**: Para estilos scoped (futuro)
- **PostCSS**: Para procesamiento avanzado
- **Stylelint**: Para linting de CSS