<!-- src/views/NotFound.vue -->
<template>
    <div>
      <h1>Página no encontrada</h1>
      <p>Lo sentimos, la página que buscas no existe.</p>
      <button @click="goHome">Volver al inicio</button>
    </div>
  </template>
  
  <script setup>
  import { useRouter } from 'vue-router'
  
  const router = useRouter()
  
  function goHome() {
    router.push('/listaPintores')  // Puedes cambiar esta ruta si quieres que vaya a otro lado
  }
  </script>