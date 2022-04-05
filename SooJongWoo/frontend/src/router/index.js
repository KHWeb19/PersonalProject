import Vue from 'vue'
import VueRouter from 'vue-router'
import HomewView from '../views/HomeView.vue'

// 메인페이지
import MainPage from '@/views/main/MainPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomewView
  },
  {
    path: '/',
    name: 'MainPage',
    component: MainPage
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
