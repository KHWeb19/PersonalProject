import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import LoginTestPage from '@/views/jpaMember/LoginTestPage.vue'

import JpaBoardListPage from '@/views/jpaBoard/JpaBoardListPage.vue'
import JpaBoardRegisterPage from '@/views/jpaBoard/JpaBoardRegisterPage.vue'
import JpaBoardReadPage from '@/views/jpaBoard/JpaBoardReadPage.vue'
import JpaBoardModifyPage from '@/views/jpaBoard/JpaBoardModifyPage.vue'

import JpaMemberAuthTestPage from '@/views/jpaMember/JpaMemberAuthTestPage.vue'
import VuetifyMemberJoinColumnTestPage from '@/views/jpaMember/VuetifyMemberJoinColumnTestPage.vue'
import DaumNewsCrawlerPage from '@/views/crawl/DaumNewsCrawlerPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },

  {
    path: '/vuetifyMemberJoinColumnTest',
    name: 'VuetifyMemberJoinColumnTestPage',
    components: {
      default: VuetifyMemberJoinColumnTestPage
    }
  },
 
  {
    path: '/login',
    name: 'LoginTestPage',
    components: {
      default: LoginTestPage
    }
  },
  {
    path: '/jpaBoardList',
    name: 'JpaBoardListPage',
    component: JpaBoardListPage
  },
  {
    path: '/jpaBoardRegister',
    name: 'JpaBoardRegisterPage',
    component: JpaBoardRegisterPage
  },
  {
    path: '/jpaBoardRead/:boardNo',
    name: 'JpaBoardReadPage',
    components: {
      default: JpaBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/jpaBoardModify/:boardNo',
    name: 'JpaBoardModifyPage',
    components: {
      default: JpaBoardModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/jpaMemberAuthTest',
    name: 'JpaMemberAuthTestPage',
    components: {
      default: JpaMemberAuthTestPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/daumNewsCrawl',
    name: 'DaumNewsCrawlerPage',
    components: {
      default: DaumNewsCrawlerPage
    },
    props: {
      default: true
    }
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
