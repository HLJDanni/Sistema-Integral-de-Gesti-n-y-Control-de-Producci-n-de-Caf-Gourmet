/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        primary: {
          DEFAULT: '#8EB486',
          50: '#f0f9f0',
          100: '#e0f2e0',
          200: '#c2e6c2',
          300: '#94d194',
          400: '#66b866',
          500: '#8EB486',
          600: '#5a8f5a',
          700: '#4a754a',
          800: '#3a5c3a',
          900: '#2a422a',
        },
        background: '#FDF7F4',
        secondary: '#B08968',
        accent: '#68563a',
        themeaccent: '#ffffff',
        themecounteraccent: '#000000',
        tulip: {
          bg: '#FDF7F4',
          green: '#A3B18A',
          brown: '#B08968',
        },
        gray: {
          400: '#9ca3af',
        },
      },
      borderRadius: {
        'box': '0.5rem',
      },
      boxShadow: {
        'xl': '0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 10px 10px -5px rgba(0, 0, 0, 0.04)',
      },
    },
  },
  plugins: [],
}