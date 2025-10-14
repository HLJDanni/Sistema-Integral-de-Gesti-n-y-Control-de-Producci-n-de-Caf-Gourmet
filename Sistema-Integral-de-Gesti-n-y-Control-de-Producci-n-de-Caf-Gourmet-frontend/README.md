# Vite + React

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

- [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin/blob/main/packages/plugin-react/README.md) uses [Babel](https://babeljs.org/) for Fast Refresh

- [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin/blob/main/packages/plugin-react-swc/README.md) uses [SWC](https://swc.rs/) for Fast Refresh

## Expanding the ESLint configuration

If you are developing a production application, we recommend updating the configuration to enable type aware lint rules:

- Configure the top level `parserOptions` in your config file with `parserOptions.project` set to `true`

- Add `"@typescript-eslint/no-unsafe-assignment": "off"` to the list of rules in your `.eslintrc.js` file
