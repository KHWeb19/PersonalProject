import Vue from 'vue'
import VueRouter from 'vue-router'

import MainPage from '../views/MainPage.vue';



import LoginPage from '../views/jpaMemberPage/LoginPage.vue'
import SignUpPage from '@/views/jpaMemberPage/SignUpPage.vue'

import DashBoardPage from '../views/DashBoardPage/DashBoardPage.vue'
import CalendarPage from '../views/DashBoardPage/CalendarPage.vue'
import ProFilePage from '../views/jpaMemberPage/ProFilePage.vue'
import Todo from '../views/TodoPage/Todo.vue'

import DataBoardListPage from '../views/DataBoardPage/DataBoardListPage.vue'
import DataBoardModifyPage from '../views/DataBoardPage/DataBoardModifyPage.vue'
import DataBoardReadPege from '../views/DataBoardPage/DataBoardReadPage.vue'
import DataBoardRegisterPage from '../views/DataBoardPage/DataBoardRegisterPage.vue'

import QuestionBoardListPage from '../views/QuestionBoardPage/QuestionBoardListPage.vue'
import QuestionBoardModifyPage from '../views/QuestionBoardPage/QuestionBoardModifyPage.vue'
import QuestionBoardReadPage from '../views/QuestionBoardPage/QuestionBoardReadPage.vue'
import QuestionBoardRegisterPage from '../views/QuestionBoardPage/QuestionBoardRegisterPage.vue'

import QBoardListPage from '@/views/QBoardPage/JpaBoardListPage.vue'
import QBoardRegisterPage from '@/views/QBoardPage/JpaBoardRegisterPage.vue'
import QBoardReadPage from '@/views/QBoardPage/JpaBoardReadPage.vue'
import QBoardModifyPage from '@/views/QBoardPage/JpaBoardModifyPage.vue'

Vue.use(VueRouter)

const routes = [

  { // 메인 페이지
    path: '/',
    name: 'MainPage',
    component: MainPage
  },
  { // 로그인
    path: '/LoginPage',
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
  { // 달력
    path: '/CalendarPage',
    name: 'CalendarPage',
    component: CalendarPage
  },
  { // 투두리스트
    path: '/Todo',
    name: 'Todo',
    component: Todo
  },
  { // 프로필 관리
    path: '/ProFilePage',
    name: 'ProFilePage',
    component: ProFilePage
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



  {
    path: '/QBoardListPage',
    name: 'QBoardListPage',
    component: QBoardListPage
  },
  {
    path: '/QBoardRegisterPage',
    name: 'QBoardRegisterPage',
    component: QBoardRegisterPage
  },
  {
    path: '/QBoardReadPage/:boardNo',
    name: 'QBoardReadPage',
    components: {
      default: QBoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/QBoardModifyPage/:boardNo',
    name: 'QBoardModifyPage',
    components: {
      default: QBoardModifyPage
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
