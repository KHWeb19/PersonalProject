import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import MainPage from '@/views/project/MainPage.vue'
import LoginPage from '@/views/project/LoginPage.vue'
import JoinPage from '@/views/project/JoinPage.vue'


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
  },
  {
    path: '/loginPage',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/joinPage',
    name: 'JoinPage',
    component: JoinPage
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
