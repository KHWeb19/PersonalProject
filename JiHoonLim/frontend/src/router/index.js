import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import SignUpPage from '@/views/member/SignUpPage.vue'
import LoginPage from '@/views/member/LoginPage.vue'
import SearchUserIdPage from '@/views/member/SearchUserIdPage.vue'
import SearchUserPwPage from '@/views/member/SearchUserPwPage.vue'
import MemberInfoPage from '@/views/member/MemberInfoPage.vue'

import FoodListPage from '@/views/foodBoard/FoodListPage.vue'
import FoodRegisterPage from '@/views/foodBoard/FoodRegisterPage.vue'
import FoodDetailPage from '@/views/foodBoard/FoodDetailPage.vue'
import FoodModifyPage from '@/views/foodBoard/FoodModifyPage.vue'
import BestFoodListPage from '@/views/foodBoard/BestFoodListPage.vue'
import FoodSearchPage from '@/views/foodBoard/FoodSearchPage.vue'
import MyCartFoodPage from '@/views/member/MyCartFoodPage.vue'

import NoticeListPage from '@/views/noticeBoard/NoticeListPage.vue'
import NoticeRegisterPage from '@/views/noticeBoard/NoticeRegisterPage.vue'
import NoticeReadPage from '@/views/noticeBoard/NoticeReadPage.vue'
import NoticeModifyPage from '@/views/noticeBoard/NoticeModifyPage.vue'

import MemberManagePage from '@/views/adminPage/MemberManagePage.vue'
import MemberManageModifyPage from '@/views/adminPage/MemberManageModifyPage.vue'

import test from '@/views/test.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/test',
    name: 'test',
    component: test
  },
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/signup',
    name: 'SignUpPage',
    component: SignUpPage
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/searchUserId',
    name: 'SearchUserIdPage',
    component: SearchUserIdPage
  },
  {
    path: '/searchUserPw',
    name: 'SearchUserPwPage',
    component: SearchUserPwPage
  },
  {
    path: '/memberInfo',
    name: 'MemberInfoPage',
    component: MemberInfoPage
    
  },
  {
    path: '/foodList',
    name: 'FoodListPage',
    component: FoodListPage
  },
  {
    path: '/foodRegister',
    name: 'FoodRegisterPage',
    component: FoodRegisterPage
  },
  {
    path: '/foodDetail/:boardNo',
    name: 'FoodDetailPage',
    components: {
      default: FoodDetailPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/foodModify/:boardNo',
    name: 'FoodModifyPage',
    components: {
      default: FoodModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/bestFoodList',
    name: 'BestFoodListPage',
    component: BestFoodListPage
  },
  {
    path: '/search/:keyWord',
    name: 'FoodSearchPage',
    components: {
      default: FoodSearchPage
    },
    props:{
      default: true
    }
  },
  {
    path: '/myCartFood',
    name: 'MyCartFoodPage',
    component: MyCartFoodPage
  },
  {
    path: '/noticeRegister',
    name: 'NoticeRegisterPage',
    component: NoticeRegisterPage
  },
  {
    path: '/noticeList',
    name: 'NoticeListPage',
    component: NoticeListPage
  },
  {
    path: '/noticeRead/:boardNo',
    name: 'NoticeReadPage',
    components: {
      default: NoticeReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/noticeModify/:boardNo',
    name: 'NoticeModifyPage',
    components: {
      default: NoticeModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/memberManage',
    name: 'MemberManagePage',
    component: MemberManagePage
  },
  {
    path: '/memberManage/:memberNo',
    name: 'MemberManageModifyPage',
    components: {
      default: MemberManageModifyPage
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
