import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/MainPage/HomeView.vue'
import Kategorie1Veiw from '@/views/Kategorie1Veiw/Kategorie1Veiw'
import Kategorie1ReadPage from '@/views/Kategorie1Veiw/Kategorie1ReadPage'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'homeView',
    component: HomeView
  },
  {
    path: '/kategorie1',
    name: 'Kategorie1Veiw',
    component: Kategorie1Veiw
  },
  {
    path:'/kategorieReadPage',
    name:'Kategorie1ReadPage',
    component: Kategorie1ReadPage
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
