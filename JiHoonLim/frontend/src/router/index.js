import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import SignUpPage from '@/views/member/SignUpPage.vue'
import LoginPage from '@/views/member/LoginPage.vue'
import SearchUserIdPage from '@/views/member/SearchUserIdPage.vue'
import MyPage from '@/views/member/MyPage.vue'

import FoodListPage from '@/views/foodBoard/FoodListPage.vue'

import test from '@/views/test.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/test',
    name: 'test',
    component: test
  },
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
    path: '/searchUserId',
    name: 'SearchUserIdPage',
    component: SearchUserIdPage
  },
  
  {
    path: '/myPage',
    name: 'MyPage',
    component: MyPage
  },
  {
    path: '/foodList',
    name: 'FoodListPage',
    component: FoodListPage
  },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
