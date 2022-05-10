import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

//자유게시판
import FreeBoardRegister from '@/views/freeBoard/FreeBoardRegisterPage.vue'
import FreeBoardListPage from '@/views/freeBoard/FreeBoardListPage.vue'
import FreeBoardReadPage from '@/views/freeBoard/FreeBoardReadPage.vue'
import FreeBoardModifyPage from '@/views/freeBoard/FreeBoardModifyPage.vue'
//사진게시판
import PhotoBoardRegister from '@/views/photoBoard/PhotoBoardRegisterPage.vue'
import PhotoBoardListPage from '@/views/photoBoard/PhotoBoardListPage.vue'
import PhotoBoardReadPage from '@/views/photoBoard/PhotoBoardReadPage.vue'
import PhotoBoardModifyPage from '@/views/photoBoard/PhotoBoardModifyPage.vue'
//영상게시판
import VideoBoardRegister from '@/views/videoBoard/VideoBoardRegisterPage.vue'
import VideoBoardListPage from '@/views/videoBoard/VideoBoardListPage.vue'
import VideoBoardReadPage from '@/views/videoBoard/VideoBoardReadPage.vue'
import VideoBoardModifyPage from '@/views/videoBoard/VideoBoardModifyPage.vue'
//PLAYLIST
import PlayListPage from '@/views/music/PlayListPage.vue'
//검색기능
import SearchResult from '@/views/freeBoard/SearchListPage.vue'

Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/searchList',
    name: 'SearchResult',
    components: {
      default: SearchResult
  },
    props: {
      default: true
    }
  },

   //영상게시판
   {
    path: '/videoBoardModify/:boardNo',
    name: 'VideoBoardModifyPage',
    components: {
      default: VideoBoardModifyPage
  },
    props: {
      default: true
    }
  },
  {
    path: '/videoBoardRead/:boardNo',
    name: 'VideoBoardReadPage',
    components: {
      default: VideoBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path:'/videoBoardRegister',
    name: 'VideoBoardRegisterPage',
    component: VideoBoardRegister
  },
  {
    path: '/videoBoardList',
    name: 'VideoBoardListPage',
    component: VideoBoardListPage,
  },
    //사진게시판
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
    component: PhotoBoardRegister
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
      component: FreeBoardRegister
  },
  {
    path: '/freeBoardList',
    name: 'FreeBoardListPage',
    component: FreeBoardListPage,
  
  },
  //뮤직
  {
    path:'/playList',
    name: 'PlayListPage',
    component: PlayListPage
},

]
const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

