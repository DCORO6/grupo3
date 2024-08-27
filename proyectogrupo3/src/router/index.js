import CuadroForm from '@/views/CuadroForm.vue'
import PintoresList from '@/views/PintoresList.vue'
import PintorForm from '@/views/PintorForm.vue'
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
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
 
  ]
})

export default router
