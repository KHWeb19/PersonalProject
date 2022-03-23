import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginPage from '../views/user/LoginPage'
import RegisterPage from '../views/user/RegisterPage'
import HomeView from '../views/HomeView.vue'
import MyPage from '../views/MyPage.vue'
import AccountsEditPage from '../views/AccountsEditPage'

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
    path: '/myPage',
    name: 'MyPage',
    component: MyPage
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
