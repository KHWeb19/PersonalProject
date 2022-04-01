import Vue from 'vue'
import VueRouter from 'vue-router'

import LoginPage from '@/views/member/LoginPage'
import RegisterPage from '@/views/member/RegisterPage'

import HomeView from '@/views/HomeView.vue'
import BoardRegisterPage from '@/views/board/BoardRegisterPage'
import MyProfilePage from '@/views/member/MyProfilePage'
import AccountsEditPage from '@/views/member/AccountsEditPage'


Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/register',
    name: 'RegisterPage',
    component: RegisterPage
  },
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/board/register',
    name: 'BoardRegisterPage',
    component: BoardRegisterPage
  },
  {
    path: '/profile',
    name: 'MyProfilePage',
    component: MyProfilePage
  },
  {
    path: '/accounts/edit',
    name: 'AccountsEditPage',
    component: AccountsEditPage
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
