import Vue from 'vue'
import VueRouter from 'vue-router'
import HomewView from '../views/HomeView.vue'

// 메인페이지
import MainPage from '@/views/main/MainPage.vue'

// 로그인
import MemberLogin from '@/views/member/MemberLogin.vue'

// 회원가입
import MemberRegister from '@/views/member/MemberRegister.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomewView
  },
  {
    path: '/hawul',
    name: 'MainPage',
    component: MainPage
  },
  {
    path: '/login',
    name: 'MemberLogin',
    component: MemberLogin
  },
  {
    path: '/memberRegister',
    name: 'MemberRegister',
    component: MemberRegister
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
