<script setup>
</script>

<template>
  <header>
    <div class="wrapper">
      <h1>Galería de Arte</h1>
      
    </div>
  </header>
  
  <main>
    <section class="intro">
      <h2>Bienvenidos a nuestra Galería de Arte</h2>
      <p>Explora una colección única de cuadros y conoce a los pintores detrás de cada obra maestra.</p>
      <br><br><br>
      <button class="enter-button">Entrar</button>

      <nav>
      <router-link to="/pintores">Ver Lista de Pintores</router-link>
    </nav>
    <router-view></router-view>
    </section>
  </main>
</template>

<style scoped>
body {
  font-family: 'Arial', sans-serif;
  background-color: #f0e6f6; /* Color de fondo suave */
  color: #333;
  margin: 0;
  padding: 0;
}

header {
  background-color: #333;
  color: #fff;
  padding: 1rem;
  text-align: center;
}

header .wrapper {
  display: flex;
  align-items: center;
  justify-content: center;
}

.logo {
  height: 50px;
  margin-right: 1rem;
}

h1 {
  margin: 0;
  font-size: 2rem;
}

main {
  padding: 2rem;
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
  color: #666;
}

.enter-button {
  background-color: #ff6347; /* Color llamativo */
  color: white;
  border: none;
  padding: 0.75rem 1.5rem;
  font-size: 1rem;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.enter-button:hover {
  background-color: #ff4500; /* Color al pasar el ratón */
}

.gallery {
  display: flex;
  flex-wrap: wrap;
  gap: 2rem;
  justify-content: center;
}

.art-piece {
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 8px;
  overflow: hidden;
  width: 200px;
  text-align: center;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.art-piece img {
  width: 100%;
  height: auto;
}

.art-piece h3 {
  margin: 0.5rem 0;
  font-size: 1.2rem;
}

.art-piece p {
  margin: 0;
  font-size: 1rem;
  color: #666;
  padding-bottom: 1rem;
}
</style>