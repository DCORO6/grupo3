<template>
  <div class="container">
    <h2>Lista de Pintores y Cuadros</h2>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Nacionalidad</th>
          <th>Cuadros</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="pintor in pintores" :key="pintor.id">
          <td>{{ pintor.id }}</td>
          <td>{{ pintor.nombre }}</td>
          <td>{{ pintor.nacionalidad }}</td>
          <td>
            <ul>
              <li v-for="cuadro in getCuadrosPorPintor(pintor.id)" :key="cuadro.id">
                {{ cuadro.titulo }} ({{ cuadro.ano }})
              </li>
            </ul>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from '@/axios';

const pintores = ref([]);
const cuadros = ref([]);

onMounted(async () => {
  try {
    const pintoresResponse = await axios.get('/pintores');
    pintores.value = pintoresResponse.data;

    const cuadrosResponse = await axios.get('/cuadros');
    cuadros.value = cuadrosResponse.data;
  } catch (error) {
    console.error('Error fetching data:', error);
  }
});

function getCuadrosPorPintor(pintorId) {
  return cuadros.value.filter(cuadro => cuadro.pintor.id === pintorId);
}
</script>

<style scoped>
.container {
  padding: 20px;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
}

th {
  background-color: #f2f2f2;
}
</style>