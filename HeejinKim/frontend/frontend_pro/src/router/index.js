import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import MainPage from '@/views/main/MainPage.vue'
import RegisterPage from '@/views/login/RegisterPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/main',
    name: 'MainPage',
    components: {
       MainPage
    } 
  },
  {
    path: '/',
    name: 'RegisterPage',
    components: RegisterPage
  },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
