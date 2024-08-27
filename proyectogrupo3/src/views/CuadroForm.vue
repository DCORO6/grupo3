<template>
    <div>
      <h1>Añadir Cuadro</h1>
      <form @submit.prevent="submitForm">
        <label for="titulo">Título:</label>
        <input v-model="cuadro.titulo" id="titulo" required />
        <label for="anio">Año:</label>
        <input v-model="cuadro.anio" id="anio" type="number" required />
        <button type="submit">Guardar</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from '../axios';
  
  export default {
    data() {
      return {
        cuadro: {
          titulo: '',
          anio: '',
          pintor: {
            id: this.$route.params.pintorId,
          },
        },
      };
    },
    methods: {
      async submitForm() {
        await axios.post('cuadros', this.cuadro);
        this.$router.push('/pintores');
      },
    },
  };
  </script>
  