import Vue from 'vue'
import VueRouter from 'vue-router'

import LoginPage from '../views/jpaMemberPage/LoginPage.vue'
import SignUpPage from '@/views/jpaMemberPage/SignUpPage.vue'

import DashBoardPage from '../views/DashBoardPage/DashBoardPage.vue'

import DataBoardListPage from '../views/DataBoardPage/DataBoardListPage.vue'
import DataBoardModifyPage from '../views/DataBoardPage/DataBoardModifyPage.vue'
import DataBoardReadPege from '../views/DataBoardPage/DataBoardReadPage.vue'
import DataBoardRegisterPage from '../views/DataBoardPage/DataBoardRegisterPage.vue'

import QuestionBoardListPage from '../views/QuestionBoardPage/QuestionBoardListPage.vue'
import QuestionBoardModifyPage from '../views/QuestionBoardPage/QuestionBoardModifyPage.vue'
import QuestionBoardReadPage from '../views/QuestionBoardPage/QuestionBoardReadPage.vue'
import QuestionBoardRegisterPage from '../views/QuestionBoardPage/QuestionBoardRegisterPage.vue'

Vue.use(VueRouter)

const routes = [

  { // 로그인
    path: '/',
    name: 'LoginPage',
    component: LoginPage
  },
  { // 회원가입
    path: '/SignUpPage',
    name: 'SignUpPage',
    component: SignUpPage
  },
  { // Dash 보드
    path: '/DashBoardPage',
    name: 'DashBoardPage',
    component: DashBoardPage
  },

  
  { // 자료 게시판 목록
    path: '/DataBoardListPage',
    name: 'DataBoardListPage',
    component: DataBoardListPage
  },
  { // 자료 게시판 수정
    path: '/DataBoardModifyPage',
    name: 'DataBoardModifyPage',
    component: DataBoardModifyPage
  },
  { // 자료 게시판 읽기
    path: '/DataBoardReadPege',
    name: 'DataBoardReadPege',
    component: DataBoardReadPege
  },
  { // 자료 게시판 등록
    path: '/DataBoardRegisterPage',
    name: 'DataBoardRegisterPage',
    component: DataBoardRegisterPage
  },


  { // 질문 게시판 목록
    path: '/QuestionBoardListPage',
    name: 'QuestionBoardListPage',
    component: QuestionBoardListPage
  },
  { // 질문 게시판 수정
    path: '/QuestionBoardModifyPage',
    name: 'QuestionBoardModifyPage',
    component: QuestionBoardModifyPage
  },
  {// 질문 게시판 읽기
    path: '/QuestionBoardReadPage',
    name: 'QuestionBoardReadPage',
    component: QuestionBoardReadPage
  },
  {// 질문 게시판 등록
    path: '/QuestionBoardRegisterPage',
    name: 'QuestionBoardRegisterPage',
    component: QuestionBoardRegisterPage
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
