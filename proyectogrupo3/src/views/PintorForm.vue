<template>
    <div>
      <h1>{{ isEdit ? 'Editar' : 'Añadir' }} Pintor</h1>
      <form @submit.prevent="submitForm">
        <label for="nombre">Nombre:</label>
        <input v-model="pintor.nombre" id="nombre" required />
        <label for="nacionalidad">Nacionalidad:</label>
        <input v-model="pintor.nacionalidad" id="nacionalidad" required />
        <button type="submit">{{ isEdit ? 'Actualizar' : 'Guardar' }}</button>
      </form>
    </div>
  </template>
  
  <script>
  import axios from '../axios';
  
  export default {
    data() {
      return {
        pintor: {
          nombre: '',
          nacionalidad: '',
        },
        isEdit: false,
      };
    },
    created() {
      const id = this.$route.params.id;
      if (id) {
        this.isEdit = true;
        this.fetchPintor(id);
      }
    },
    methods: {
      async fetchPintor(id) {
        const response = await axios.get(`/api/pintores/${id}`);
        this.pintor = response.data;
      },
      async submitForm() {
        const id = this.$route.params.id;
        if (this.isEdit) {
          await axios.put(`/api/pintores/${id}`, this.pintor);
        } else {
          await axios.post('/api/pintores', this.pintor);
        }
        this.$router.push('/pintores');
      },
    },
  };
  </script>
  