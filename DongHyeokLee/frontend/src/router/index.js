import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

import FreeBoardReigster from '@/views/freeBoard/FreeBoardRegisterPage.vue'
import FreeBoardListPage from '@/views/freeBoard/FreeBoardListPage.vue'
import FreeBoardReadPage from '@/views/freeBoard/FreeBoardReadPage.vue'
import FreeBoardModifyPage from '@/views/freeBoard/FreeBoardModifyPage.vue'
import store from '@/store'





Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/boardModify/:boardNo',
    name: 'FreeBoardModifyPage',
    components: {
      default: FreeBoardModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/freeBoardRead/:boardNo',
    name: 'FreeBoardReadPage',
    components: {
      default: FreeBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
      path:'/freeBoardRegister',
      name: 'FreeBoardRegisterPage',
      component: FreeBoardReigster
  },
  {
    path: '/freeBoardList',
    name: 'FreeBoardListPage',
    component: FreeBoardListPage,
    meta: {isLogin: true}
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

router.beforeEach((to, from, next) => {
  if(to.meta.isLogin && !store.state.isLogin){
    alert('로그인 해주세요!')

  }else{
    next();
  }
  
})