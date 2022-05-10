import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import MainPage from '../components/main/MainPage.vue'

import RegisterPage from '@/views/stockMember/RegisterPage.vue'
import LoginPage from '@/views/stockMember/LoginPage.vue'

import LocalBoardListPage from '@/views/stockBoard/local/LocalBoardListPage.vue'
import LocalBoardRegisterPage from '@/views/stockBoard/local/LocalBoardRegisterPage.vue'
import LocalBoardReadPage from '@/views/stockBoard/local/LocalBoardReadPage.vue'
import LocalBoardModifyPage from '@/views/stockBoard/local/LocalBoardModifyPage.vue'

import ForeignBoardListPage from '@/views/stockBoard/foreign/ForeignBoardListPage.vue'
import ForeignBoardRegisterPage from '@/views/stockBoard/foreign/ForeignBoardRegisterPage.vue'
import ForeignBoardReadPage from '@/views/stockBoard/foreign/ForeignBoardReadPage.vue'
import ForeignBoardModifyPage from '@/views/stockBoard/foreign/ForeignBoardModifyPage.vue'

import QuestionBoardListPage from '@/views/stockBoard/question/QuestionBoardListPage.vue'
import QuestionBoardRegisterPage from '@/views/stockBoard/question/QuestionBoardRegisterPage.vue'
import QuestionBoardReadPage from '@/views/stockBoard/question/QuestionBoardReadPage.vue'
import QuestionBoardModifyPage from '@/views/stockBoard/question/QuestionBoardModifyPage.vue'

import ComplaintBoardListPage from '@/views/stockBoard/complaint/ComplaintBoardListPage.vue'
import ComplaintBoardRegisterPage from '@/views/stockBoard/complaint/ComplaintBoardRegisterPage.vue'
import ComplaintBoardReadPage from '@/views/stockBoard/complaint/ComplaintBoardReadPage.vue'
import ComplaintBoardModifyPage from '@/views/stockBoard/complaint/ComplaintBoardModifyPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/stock',
    name: 'MainPage',
    components: {
      default: MainPage
    }
  },
  {
    path: '/stock/register',
    name: 'RegisterPage',
    components: {
      default: RegisterPage
    }
  },
  {
    path: '/stock/login',
    name: 'LoginPage',
    components: {
      default: LoginPage
    }
  },
  {
    path: '/stock/LocalList',
    name: 'LocalBoardListPage',
    component: LocalBoardListPage
  },
  {
    path: '/stock/LocalRegister',
    name: 'LocalBoardRegisterPage',
    component: LocalBoardRegisterPage
  },
  {
    path: '/stock/LocalRead/:boardNo',
    name: 'LocalBoardReadPage',
    components: {
      default: LocalBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/stock/LocalBoardModify/:boardNo',
    name: 'LocalBoardModifyPage',
    components: {
      default: LocalBoardModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/stock/ForeignList',
    name: 'ForeignBoardListPage',
    component: ForeignBoardListPage
  },
  {
    path: '/stock/ForeignRegister',
    name: 'ForeignBoardRegisterPage',
    component: ForeignBoardRegisterPage
  },
  {
    path: '/stock/ForeignRead/:boardNo',
    name: 'ForeignBoardReadPage',
    components: {
      default: ForeignBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/stock/ForeignBoardModify/:boardNo',
    name: 'ForeignBoardModifyPage',
    components: {
      default: ForeignBoardModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/stock/QuestionList',
    name: 'QuestionBoardListPage',
    component: QuestionBoardListPage
  },
  {
    path: '/stock/QuestionRegister',
    name: 'QuestionBoardRegisterPage',
    component: QuestionBoardRegisterPage
  },
  {
    path: '/stock/QuestionRead/:boardNo',
    name: 'QuestionBoardReadPage',
    components: {
      default: QuestionBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/stock/QuestionBoardModify/:boardNo',
    name: 'QuestionBoardModifyPage',
    components: {
      default: QuestionBoardModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/stock/ComplaintList',
    name: 'ComplaintBoardListPage',
    component: ComplaintBoardListPage
  },
  {
    path: '/stock/ComplaintRegister',
    name: 'ComplaintBoardRegisterPage',
    component: ComplaintBoardRegisterPage
  },
  {
    path: '/stock/ComplaintRead/:boardNo',
    name: 'ComplaintBoardReadPage',
    components: {
      default: ComplaintBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/stock/ComplaintBoardModify/:boardNo',
    name: 'ComplaintBoardModifyPage',
    components: {
      default: ComplaintBoardModifyPage
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
