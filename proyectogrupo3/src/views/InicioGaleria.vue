<template>
    <div class="container">
      <div class="top-section">
        <header>
          <div class="wrapper">
            <h1>Bienvenidos a nuestra Galería de Arte</h1>
          </div>
        </header>
  
        <main>
          <section class="intro">
            <div class="wrapper">
            <h2>Explora nuestra colección de pintores y sus obras</h2>
            </div>
              <p>En nuestra galería podrás encontrar una amplia colección de pintores y sus obras más destacadas.</p>
              <p>¡No te lo pierdas!</p>
            <img src="@/assets/img/monalisa.jpg" alt="Monalisa">
            <br><br>
          </section>
        </main>
      </div>
      
      <div class="bottom-section">
        <img class="tickets" src="@/assets/img/tickets.png" alt="tickets">
        <button class="enter-button" @click="goToPintores">Entrar</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { useRouter } from 'vue-router'
  
  const router = useRouter()
  
  function goToPintores() {
    console.log('Navigating to /listaPintores')
    router.push('/listaPintores')
  }
  </script>
  
  <style scoped>
  body {
    margin: 0;
    padding: 0;
    font-family: 'Arial', sans-serif;
  }
  .tickets {
    width: 300px;
  }
  
  .container {
    display: flex;
    flex-direction: column;
    height: 100vh;
  }
  
  .top-section {
    background-color: rgb(53, 25, 45);
    color: white;
    flex: 1; 
  }
  
  .bottom-section {
    display: flex;
    align-items: center;
    justify-content: center;  
    background-color: rgb(82, 82, 82);
    color: white;
    flex-direction: column;
  
    flex: 1; /* Ocupa la mitad inferior de la pantalla */
  }
  
  header {
    padding: 1rem;
    text-align: center;
  }
  
  header .wrapper {
    display: flex;
    align-items: center;
    justify-content: center;
  }
  
  h1 {
    margin: 0;
    font-size: 2rem;
  }
  
  
  
  .intro {
    text-align: center;
    margin-bottom: 2rem;
  }
  
  .intro h2 {
    font-size: 1.5rem;
    margin-bottom: 0.5rem;
  }
  
  .intro p {
    font-size: 1rem;
    color: #ff4500;
  }
  
  .enter-button {
    margin-top: 10px;
    background-color: #ff6347; /* Color llamativo */
    color: white;
    border: none;
    padding: 0.75rem 7rem;
    font-size: 1.5rem;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  
  .enter-button:hover {
    background-color: #ff4500; /* Color al pasar el ratón */
  }
  </style>
  