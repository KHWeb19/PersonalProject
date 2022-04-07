import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import LoginTestPage from '@/views/jpaMember/LoginTestPage.vue'
import JpaBoardListPage from '@/views/jpaBoard/JpaBoardListPage.vue'
import JpaBoardListPage1 from '@/views/jpaBoard1/JpaBoardListPage1.vue'
import JpaBoardListPage2 from '@/views/jpaBoard2/JpaBoardListPage2.vue'




import JpaBoardRegisterPage from '@/views/jpaBoard/JpaBoardRegisterPage.vue'
import JpaBoardRegisterPage1 from '@/views/jpaBoard1/JpaBoardRegisterPage1.vue'
import JpaBoardRegisterPage2 from '@/views/jpaBoard2/JpaBoardRegisterPage2.vue'


import JpaBoardReadPage from '@/views/jpaBoard/JpaBoardReadPage.vue'
import JpaBoardReadPage1 from '@/views/jpaBoard1/JpaBoardReadPage1.vue'
import JpaBoardReadPage2 from '@/views/jpaBoard2/JpaBoardReadPage2.vue'

import JpaBoardModifyPage from '@/views/jpaBoard/JpaBoardModifyPage.vue'
import JpaBoardModifyPage1 from '@/views/jpaBoard1/JpaBoardModifyPage1.vue'
import JpaBoardModifyPage2 from '@/views/jpaBoard2/JpaBoardModifyPage2.vue'

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
    path: '/jpaBoardList1',
    name: 'JpaBoardListPage1',
    component: JpaBoardListPage1
  },

  {
    path: '/jpaBoardList2',
    name: 'JpaBoardListPage2',
    component: JpaBoardListPage2
  },


  {
    path: '/jpaBoardRegister',
    name: 'JpaBoardRegisterPage',
    component: JpaBoardRegisterPage
  },
  

  
  {
    path: '/jpaBoardRegister1',
    name: 'JpaBoardRegisterPage1',
    component: JpaBoardRegisterPage1
  },

  {
    path: '/jpaBoardRegister2',
    name: 'JpaBoardRegisterPage2',
    component: JpaBoardRegisterPage2
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
    path: '/jpaBoardRead1/:boardNo1',
    name: 'JpaBoardReadPage1',
    components: {
      default: JpaBoardReadPage1
    },
    props: {
      default: true
    }
  },


  {
    path: '/jpaBoardRead2/:boardNo2',
    name: 'JpaBoardReadPage2',
    components: {
      default: JpaBoardReadPage2
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
    path: '/jpaBoardModify1/:boardNo1',
    name: 'JpaBoardModifyPage1',
    components: {
      default: JpaBoardModifyPage1
    },
    props: {
      default: true
    }
  },

  {
    path: '/jpaBoardModify2/:boardNo2',
    name: 'JpaBoardModifyPage2',
    components: {
      default: JpaBoardModifyPage2
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