import InicioGaleria from '@/views/InicioGaleria.vue'
import CuadroForm from '@/views/CuadroForm.vue'
import PintoresList from '@/views/PintoresList.vue'
import PintorForm from '@/views/PintorForm.vue'
import ListaPintores from '@/views/ListaPintores.vue'
import NoEncontrado from '@/views/NoEncontrado.vue' 
import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: InicioGaleria,
    },
    {
      path: '/pintores',
      component: PintoresList,
    },
    {
      path: '/pintores/add',
      component: PintorForm,
    },
    {
      path: '/pintores/edit/:id',
      component: PintorForm,
      props: true,
    },
    {
      path: '/cuadros/add/:pintorId',
      component: CuadroForm,
      props: true,
    },
    {
      path: '/listaPintores',
      component: ListaPintores,
    },
    // Ruta para manejar páginas no encontradas
    {
      path: '/:pathMatch(.*)*',
      component: NoEncontrado  
    }
 
  ]
})

export default router
