import Vue from 'vue'
import VueRouter from 'vue-router'
import Dashboard from '@/views/DashBoard.vue'
import GridSystem from '@/views/GridSystem.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Dashboard',
    component: Dashboard
  },
  {
    path: '/grid-system',
    name: 'GridSystem',
    component: GridSystem
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
