<template>
  <div>
    <h1>{{ isEdit ? 'Editar' : 'Añadir' }} Pintor</h1>
    <form @submit.prevent="submitForm">
      <div>
        <label for="nombre">Nombre:</label>
        <input v-model="pintor.nombre" id="nombre" required />
      </div>
      <div>
        <label for="nacionalidad">Nacionalidad:</label>
        <input v-model="pintor.nacionalidad" id="nacionalidad" required />
      </div>
      <div>
        <button type="submit">{{ isEdit ? 'Actualizar' : 'Guardar' }}</button>
        <button type="button" @click="cancel">Cancelar</button>
      </div>
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
    cancel() {
      this.$router.push('/pintores');
    }
  },
};
</script>

<style scoped>
h1 {
  font-size: 24px;
  margin-bottom: 20px;
}
form {
  display: flex;
  flex-direction: column;
}
div {
  margin-bottom: 15px;
}
label {
  margin-bottom: 5px;
  font-weight: bold;
}
input {
  padding: 8px;
  font-size: 16px;
  border: 1px solid #ddd;
  border-radius: 4px;
}
button {
  background-color: #42b983;
  color: white;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  font-size: 16px;
  margin-right: 10px;
}
button:hover {
  background-color: #36986a;
}
button[type="button"] {
  background-color: #f44336;
}
button[type="button"]:hover {
  background-color: #d32f2f;
}
</style>
