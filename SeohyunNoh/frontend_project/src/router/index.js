import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store'
import Home from '../views/Home.vue'

import MainPage from '@/views/project/MainPage.vue'
import LoginPage from '@/views/project/LoginPage.vue'
import JoinPage from '@/views/project/JoinPage.vue'
import MyPage from '@/views/project/MyPage.vue'

import LookBookPage from '@/views/project/LookBookPage.vue'

import WomenCategoryPage from '@/views/project/WomenCategoryPage.vue'
import MenCategoryPage from '@/views/project/MenCategoryPage.vue'
import SaleCategoryPage from '@/views/project/SaleCategoryPage.vue'

import NoticeListPage from '@/views/notice/NoticeListPage.vue'
import NoticeReadPage from '@/views/notice/NoticeReadPage.vue'
import NoticeRegisterPage from '@/views/notice/NoticeRegisterPage.vue'
import NoticeModifyPage from '@/views/notice/NoticeModifyPage.vue'

import WomenOuterCategoryPage from '@/views/womenCategory/WomenOuterCategoryPage.vue'
import ProductDetailPage from '@/views/womenCategory/ProductDetailPage.vue'

import CartPage from '@/views/pay/CartPage.vue'
import PayPage from '@/views/pay/PayPage.vue'

Vue.use(VueRouter)

// const rejectAuthUser = (to, from, next) => {
//   if(store.state.isLogin === true) {
//     //이미 로그인된 유저니까 막아야하는 페이지 
//     alert('이미 로그인을 하였습니다.')
//     next('/mainPage')
//   }
//   else {
//     next()
//   }
// }

const onlyAuthUser = (to, from, next) => {
  if(store.state.isLogin === false) {
    //아직 로그인이 안된 유저니까 막아야하는 페이지 
    alert('로그인이 필요한 서비스입니다.')
    next('/loginPage')
  }
  else {
    next()
  }
}

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/mainPage',
    name: 'MainPage',
    component: MainPage
  },
  {
    path: '/loginPage',
    name: 'LoginPage',
    beforeEnter: (to, from, next) => {
      if(store.state.isLogin === true) {
        //이미 로그인된 유저니까 막아야하는 페이지 
        alert('이미 로그인을 하였습니다.')
        next('/mainPage')
      }
      else {
        next()
      }
    },
    component: LoginPage
  },
  {
    path: '/joinPage',
    name: 'JoinPage',
    component: JoinPage
  },
  {
    path: '/myPage',
    name: 'MyPage',
    beforeEnter: onlyAuthUser,
    component: MyPage
  },
  {
    path: '/womenCategoryPage',
    name: 'WomenCategoryPage',
    component: WomenCategoryPage
  },
  {
    path: '/menCategoryPage',
    name: 'MenCategoryPage',
    component: MenCategoryPage
  },
  {
    path: '/saleCategoryPage',
    name: 'SaleCategoryPage',
    component: SaleCategoryPage
  },
  {
    path: '/noticeListPage',
    name: 'NoticeListPage',
    component: NoticeListPage
  },
  {
    path: '/noticeReadPage/:boardNo',
    name: 'NoticeReadPage',
    components: {
      default: NoticeReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/noticeRegisterPage',
    name: 'NoticeRegisterPage',
    component: NoticeRegisterPage
  },
  {
    path: '/noticeModifyPage/:boardNo',
    name: 'NoticeModifyPage',
    components: {
      default: NoticeModifyPage
    },
    props: {
      default: true
    }

  },
  {
    path: '/womenOuterCategoryPage',
    name: 'WomenOuterCategoryPage',
    component: WomenOuterCategoryPage
  },
  {
    path: '/productDetail',
    name: 'ProductDetailPage',
    component: ProductDetailPage
  },
  {
    path: '/lookBookPage',
    name: 'LookBookPage',
    component: LookBookPage
  },
  {
    path: '/cartPage',
    name: 'CartPage',
    component: CartPage
  },
  {
    path: '/payPage',
    name: 'PayPage',
    component: PayPage
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
