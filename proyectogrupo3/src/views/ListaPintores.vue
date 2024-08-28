<template>
  <div class="container mt-5">
    <h1 class="text-center mb-5 text-primary">Art Gallery</h1>

    <div class="row justify-content-center">
      <!-- Lista de Pintores -->
      <div class="col-lg-5 mb-5">
        <div class="card shadow-sm">
          <div class="card-header bg-primary text-white text-center">
            <h2>Pintores</h2>
          </div>
          <div class="card-body">
            <table class="table table-striped table-hover">
              <thead class="thead-dark">
                <tr>
                  <th>ID</th>
                  <th>Nombre</th>
                  <th>Nacionalidad</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="pintor in pintores" :key="pintor.id">
                  <td>{{ pintor.id }}</td>
                  <td>{{ pintor.nombre }}</td>
                  <td>{{ pintor.nacionalidad }}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>

      <!-- Lista de Cuadros -->
      <div class="col-lg-5 mb-5">
        <div class="card shadow-sm">
          <div class="card-header bg-primary text-white text-center">
            <h2>Cuadros</h2>
          </div>
          <div class="card-body">
            <table class="table table-striped table-hover">
              <thead class="thead-dark">
                <tr>
                  <th>ID</th>
                  <th>Título</th>
                  <th>Año</th>
                  <th>Pintor ID</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="cuadro in cuadros" :key="cuadro.id">
                  <td>{{ cuadro.id }}</td>
                  <td>{{ cuadro.titulo }}</td>
                  <td>{{ cuadro.ano }}</td>
                  <td>{{ cuadro.pintor_id }}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from '@/axios';

const pintores = ref([]);
const cuadros = ref([]);

const fetchPintores = async () => {
  try {
    const response = await axios.get('/pintores');
    pintores.value = response.data;
  } catch (error) {
    console.error('Error fetching pintores:', error);
  }
};

const fetchCuadros = async () => {
  try {
    const response = await axios.get('/cuadros');
    cuadros.value = response.data;
  } catch (error) {
    console.error('Error fetching cuadros:', error);
  }
};

onMounted(() => {
  fetchPintores();
  fetchCuadros();
});
</script>

<style scoped>
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

h1 {
  font-family: 'Roboto', sans-serif;
  font-weight: bold;
}

.card {
  border-radius: 10px;
}

.card-header {
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

.table {
  margin: 0 auto;
  text-align: center;
}

.table th, .table td {
  vertical-align: middle;
}

.table-striped tbody tr:nth-of-type(odd) {
  background-color: #f2f2f2;
}

.table-hover tbody tr:hover {
  background-color: #e9ecef;
}
</style>