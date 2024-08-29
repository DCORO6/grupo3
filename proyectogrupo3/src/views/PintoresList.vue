<template>
  <div>
    <h1>Pintores</h1>
    <button @click="addPintor">Añadir Pintor</button>
    <ul>
      <li v-for="pintor in pintores" :key="pintor.id">
        {{ pintor.nombre }} - {{ pintor.nacionalidad }}
        <button @click="editPintor(pintor.id)">Editar</button>
        <button @click="deletePintor(pintor.id)">Eliminar</button>
        <button @click="addCuadro(pintor.id)">Añadir Cuadro</button>
      </li>
    </ul>
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
      const response = await axios.get('/api/pintores');
      this.pintores = response.data;
    },
    addPintor() {
      this.$router.push('/pintores/add');
    },
    async deletePintor(id) {
      await axios.delete(`/api/pintores/${id}`);
      this.fetchPintores();
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
h1 {
  font-size: 24px;
  margin-bottom: 20px;
}
button {
  margin-left: 10px;
  background-color: #42b983;
  color: white;
  border: none;
  padding: 5px 10px;
  cursor: pointer;
}
button:hover {
  background-color: #36986a;
}
ul {
  list-style: none;
  padding: 0;
}
li {
  margin-bottom: 10px;
}
</style>
