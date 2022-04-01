import Vue from 'vue'
import VueRouter from 'vue-router'
import MainLogin from '../views/LoginPage/MainLogin.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'MainLogin.vue',
    component: MainLogin
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
