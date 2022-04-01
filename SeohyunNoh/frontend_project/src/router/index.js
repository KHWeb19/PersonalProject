import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import MainPage from '@/views/project/MainPage.vue'
import LoginPage from '@/views/project/LoginPage.vue'
import JoinPage from '@/views/project/JoinPage.vue'

import WomenCategoryPage from '@/views/project/WomenCategoryPage.vue'
import MenCategoryPage from '@/views/project/MenCategoryPage.vue'
import SaleCategoryPage from '@/views/project/SaleCategoryPage.vue'


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
  },
  {
    path: '/womenCategoryPage',
    name: 'WomenCategoryPage',
    component: WomenCategoryPage
  },
  {
    path: '/menCategoryPage',
    name: 'MenCategoryPage',
    component: MenCategoryPage
  },
  {
    path: '/saleCategoryPage',
    name: 'SaleCategoryPage',
    component: SaleCategoryPage
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
