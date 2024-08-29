<template>
  <div>
    <div style="display: flex;">
      <h1>Pintores</h1>

    <button class="anadir" @click="addPintor">
      <img src="@/assets/img/anadir.png" />
      </button>
    </div>
    
    <table>
      <thead>
        <tr>
          <th>Nombre</th>
          <th>Nacionalidad</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="pintor in pintores" :key="pintor.id">
          <td>{{ pintor.nombre }}</td>
          <td>{{ pintor.nacionalidad }}</td>
          <td>
            <button @click="editPintor(pintor.id)">Editar</button>
            <button @click="deletePintor(pintor.id)">Eliminar</button>
            <button @click="addCuadro(pintor.id)">Añadir Cuadro</button>
          </td>
        </tr>
      </tbody>
    </table>
    <router-view></router-view>
  </div>
</template>

<script>
import axios from '../axios';

export default {
  data() {
    return {
      pintores: [],
    };
  },
  created() {
    this.fetchPintores();
  },
  methods: {
    async fetchPintores() {
      try {
        const response = await axios.get('/api/pintores');
        this.pintores = response.data;
      } catch (error) {
        console.error('Error fetching pintores:', error);
      }
    },
    addPintor() {
      this.$router.push('/pintores/add');
    },
    async deletePintor(id) {
      try {
        await axios.delete(`/api/pintores/${id}`);
        this.fetchPintores();
      } catch (error) {
        console.error('Error deleting pintor:', error);
      }
    },
    editPintor(id) {
      this.$router.push(`/pintores/edit/${id}`);
    },
    addCuadro(pintorId) {
      this.$router.push(`/cuadros/add/${pintorId}`);
    },
  },
};
</script>

<style scoped>
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

th, td {
  padding: 10px;
  border: 1px solid #ddd;
  text-align: left;
}

th {
  background-color: #f4f4f4;
}

button {
  margin-right: 5px;
}

.anadir{

  margin-left: 15px;
  img{
    width: 30px;
  }
}
</style>
