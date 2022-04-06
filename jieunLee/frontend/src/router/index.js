import Vue from 'vue'
import VueRouter from 'vue-router'

import LoginPage from '@/views/member/LoginPage'
import RegisterPage from '@/views/member/RegisterPage'

import HomeView from '@/views/HomeView.vue'
import MyProfilePage from '@/views/member/MyProfilePage'
import AccountsEditPage from '@/views/member/AccountsEditPage'
import PasswordEditPage from '@/views/member/PasswordEditPage'

import BoardRegisterPage from '@/views/board/BoardRegisterPage'


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
    component: RegisterPage,
  },
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/:memberNo',
    name: 'MyProfilePage',
    components: {
      default: MyProfilePage
    },
    props: {
      default: true
    }
  },
  {
    path: '/accounts/edit/:memberNo',
    name: 'AccountsEditPage',
    components: {
      default: AccountsEditPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/password/edit',
    name: 'PasswordEditPage',
    component: PasswordEditPage
  },
  {
    path: '/board/register',
    name: 'BoardRegisterPage',
    component: BoardRegisterPage
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
