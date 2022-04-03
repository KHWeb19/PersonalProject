import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/MainPage/HomeView.vue'
import TestPage from '@/views/TestPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'homeView',
    component: HomeView
  },
  {
    path: '/Test',
    name: 'TestPage',
    component: TestPage
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
