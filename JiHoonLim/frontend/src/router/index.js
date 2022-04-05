import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import SignUpPage from '@/views/signUp/SignUpPage.vue'
import LoginPage from '@/views/login/LoginPage.vue'

import test from '@/views/test.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/signup',
    name: 'SignUpPage',
    component: SignUpPage
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/test',
    name: 'test',
    component: test
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
