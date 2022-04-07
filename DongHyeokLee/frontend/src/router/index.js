import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

//자유게시판
import FreeBoardReigster from '@/views/freeBoard/FreeBoardRegisterPage.vue'
import FreeBoardListPage from '@/views/freeBoard/FreeBoardListPage.vue'
import FreeBoardReadPage from '@/views/freeBoard/FreeBoardReadPage.vue'
import FreeBoardModifyPage from '@/views/freeBoard/FreeBoardModifyPage.vue'
//사진게시판
import PhotoBoardReigster from '@/views/photoBoard/PhotoBoardRegisterPage.vue'
import PhotoBoardListPage from '@/views/photoBoard/PhotoBoardListPage.vue'
import PhotoBoardReadPage from '@/views/photoBoard/PhotoBoardReadPage.vue'
import PhotoBoardModifyPage from '@/views/photoBoard/PhotoBoardModifyPage.vue'








Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/photoBoardModify/:boardNo',
    name: 'PhotoBoardModifyPage',
    components: {
      default: PhotoBoardModifyPage
  },
    props: {
      default: true
    }
  },
  {
    path: '/photoBoardRead/:boardNo',
    name: 'PhotoBoardReadPage',
    components: {
      default: PhotoBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path:'/photoBoardRegister',
    name: 'PhotoBoardRegisterPage',
    component: PhotoBoardReigster
  },
  {
    path: '/photoBoardList',
    name: 'PhotoBoardListPage',
    component: PhotoBoardListPage,
  },
  //자유게시판
  {
    path: '/freeBoardModify/:boardNo',
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
  
  }

]
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

