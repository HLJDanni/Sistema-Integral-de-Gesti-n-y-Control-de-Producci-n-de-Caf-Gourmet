import { http } from './http';

export async function loginApi({ username, password }) {
  const { data } = await http.post('/auth/login', { username, password }); // 👈 sin /api
  return data;
}

export async function registerApi({ username, password, propietario }) {
  const { data } = await http.post('/auth/register', { username, password, propietario });
  return data;
}
