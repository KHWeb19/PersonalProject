import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import MainPage from '@/views/project/MainPage.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/mainPage',
    name: 'MainPage',
    component: MainPage
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
