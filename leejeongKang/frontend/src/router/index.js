import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

import MainPage from '@/views/main/MainPage.vue'

import MemberRegisterPage from '@/views/member/MemberRegisterPage'
import LoginPage from '@/views/member/LoginPage'
import MyPage from '@/views/member/MyPage'
import EditMyPage from '@/views/member/EditMyPage'

import BoardRegisterPage from '@/views/board/BoardRegisterPage'
import BoardListPage from '@/views/board/BoardListPage'
import BoardReadPage from '@/views/board/BoardReadPage'
import BoardModifyPage from '@/views/board/BoardModifyPage'

import DoctorRegisterPage from '@/views/doctor/DoctorRegisterPage'

import DepartListPage from '@/views/ap/DepartListPage'
import DoctorReadPage from '@/views/ap/DoctorReadPage'
import DateAppointmentPage from '@/views/ap/DateAppointmentPage'
import CheckAppointmentPage from '@/views/ap/CheckAppointmentPage'

import Tlqkf from '@/views/main/Tlqkf.vue'
Vue.use(VueRouter)

const loginCheck = () => (to, from, next) => {
  if (localStorage.getItem("userInfo") != null) {
    return next()
  }
  alert("로그인 후 이용하세요!")
  next('/login')
}

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/main',
    name: 'MainPage',
    component: MainPage
  },
  {
    path: '/memberRegister',
    name: 'MemberRegisterPage',
    component: MemberRegisterPage
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/myPage',
    name: 'MyPage',
    components: {
      default: MyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/editMyInform',
    name: 'EditMyPage',
    components: {
      default: EditMyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/boardRegister',
    name: 'BoardRegisterPage',
    component: BoardRegisterPage,
    beforeEnter: loginCheck()
  },
  {
    path: '/boardList',
    name: 'BoardListPage',
    component: BoardListPage
  },
  {
    path: '/boardRead/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    },
    beforeEnter: loginCheck()
  },
  {
    path: '/boardModify/:boardNo',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/secret/doctorRegister',
    name: 'DoctorRegisterPage',
    component: DoctorRegisterPage
  },
  {
    path: '/appointment/selectDepartment',
    name: 'DepartListPage',
    component: DepartListPage,
    beforeEnter: loginCheck()
  },
  {
    path: '/doctorRead/:doctorNo',
    name: 'DoctorReadPage',
    components: {
      default: DoctorReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/appointment/selectDateTime/:doctorNo',
    name: 'DateAppointmentPage',
    components: {
      default: DateAppointmentPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/appointmentList',
    name: 'CheckAppointmentPage',
    components: {
      default: CheckAppointmentPage
    },
    beforeEnter: loginCheck(),
    props: {
      default: true
    }
  },
  {
    path: '/testzz',
    name: 'Tlqkf',
    component: Tlqkf
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
