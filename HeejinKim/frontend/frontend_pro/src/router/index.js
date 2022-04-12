import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import MainPage from '@/views/main/MainPage.vue'
//import RegisterPage from '@/views/login/RegisterPage.vue'
import LoginPage from '@/views/login/LoginPage.vue'
import MemberInfoPage from '@/views/main/MemberInfoPage.vue'
import BoardList from '@/views/board/community/BoardList.vue'
import  BoardRegister from '@/views/board/community/BoardRegister.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/Home',
    name: 'Home',
    component: Home
  },
  {
    path: '/mainPage',
    name: 'MainPage',
    components: {
       MainPage
    } 
  },
  /*
  {
    path: '/register',
    name: 'RegisterPage',
    component: RegisterPage
  },*/
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/memberInfo',
    name: 'MemberInfoPage',
    components: {
       MemberInfoPage
    }
  },
  {
    path: '/communityBoard',
    name: 'BoardList',
    component: 
      BoardList
    
  },
  {
    path: '/community/register',
    name: 'BoardRegister',
    component: BoardRegister
}
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
