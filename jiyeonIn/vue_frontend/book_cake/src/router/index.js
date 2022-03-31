import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

import MainHomepage from '@/views/CakePage/MainHomepage.vue'
import BookingPage from '@/views/CakePage/BookingPage.vue'
import BookingListPage from '@/views/CakePage/BookingListPage.vue'
import PreviewCakeImg from '@/views/CakePage/PreviewCakeImg.vue'
import ReviewPage from '@/views/CakePage/ReviewPage.vue'
import MyPage from '@/views/CakePage/MyPage.vue'
import LoginPage from '@/views/CakePage/LoginPage.vue'
import SignUpPage from '@/views/CakePage/SignUpPage.vue'
import FindIdPw from '@/views/CakePage/FindIdPw.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/MainHomepage',
    name: 'MainHomepage',
    component: MainHomepage
  },
  {
    path: '/bookingPage',
    name: 'BookingPage',
    component: BookingPage
  },
  {
    path: '/bookingList',
    name: 'BookingListPage',
    component: BookingListPage
  },
  {
    path: '/previewCake',
    name: 'PreviewCakeImg',
    component: PreviewCakeImg
  },
  {
    path: '/reviewPage',
    name: 'ReviewPage',
    component: ReviewPage
  }
  ,
  {
    path: '/myPage',
    name: 'MyPage',
    component: MyPage
  }
  ,
  {
    path: '/loginPage',
    name: 'LoginPage',
    component: LoginPage
  }
  ,
  {
    path: '/signUpPage',
    name: 'SignUpPage',
    component: SignUpPage
  }
  ,
  {
    path: '/findId',
    name: 'FindIdPw',
    component: FindIdPw
  }

  ,
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
