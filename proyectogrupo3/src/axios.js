import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:5173/', // Cambia esto por la URL de tu API
});

export default instance;
