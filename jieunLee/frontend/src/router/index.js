import Vue from 'vue'
import VueRouter from 'vue-router'

import LoginPage from '@/views/member/LoginPage'
import RegisterPage from '@/views/member/RegisterPage'
import ForgetPasswordPage from '@/views/member/ForgetPasswordPage'
import FindPasswordPage from '@/views/member/FindPasswordPage'

import HomeView from '@/views/HomeView.vue'
import MemberList from '@/components/member/MemberList'
import MyProfilePage from '@/views/member/MyProfilePage'
import AccountsEditPage from '@/views/member/AccountsEditPage'
import PasswordEditPage from '@/views/member/PasswordEditPage'

import BoardRegisterPage from '@/views/board/BoardRegisterPage'
import BoardReadPage from '@/views/board/BoardReadPage'
import BoardModifyPage from '@/views/board/BoardModifyPage'

import MyLikesList from '@/components/likes/MyLikesList'


Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/register',
    name: 'RegisterPage',
    component: RegisterPage,
  },
  {
    path: '/forgetPassword',
    name: 'ForgetPasswordPage',
    component: ForgetPasswordPage,
  },
  {
    path: '/findPassword/:memberNo',
    name: 'FindPasswordPage',
    components: {
      default: FindPasswordPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/',
    name: 'HomeView',
    component: HomeView,
    props: {
      default: true
    }
  },
  {
    path: '/memberList/:keyWord',
    name: 'MemberList',
    components: {
      default: MemberList
    },
    props: {
      default: true
    }
  },
  {
    path: '/:memberNo',
    name: 'MyProfilePage',
    components: {
      default: MyProfilePage
    },
    props: {
      default: true
    }
  },
  {
    path: '/accounts/edit/:memberNo',
    name: 'AccountsEditPage',
    components: {
      default: AccountsEditPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/accounts/password/:memberNo',
    name: 'PasswordEditPage',
    components: {
      default: PasswordEditPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/boardRegister',
    name: 'BoardRegisterPage',
    component: BoardRegisterPage
  },
  {
    path: '/boardRead/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
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
    path: '/MyLikesList/:memberNo',
    name: 'MyLikesList',
    components: {
      default: MyLikesList
    },
    props: {
      default: true
    }
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
