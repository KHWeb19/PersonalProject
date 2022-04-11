import Vue from 'vue'
import VueRouter from 'vue-router'

import MainHomepage from '@/views/CakePage/MainHomepage.vue'
import BookingPage from '@/views/CakePage/BookingPage.vue'
import BookingListPage from '@/views/CakePage/BookingListPage.vue'
import PreviewCakeImg from '@/views/CakePage/PreviewCakeImg.vue'
import ReviewPage from '@/views/CakePage/ReviewPage.vue'
import MyPage from '@/views/CakePage/MyPage.vue'
import LoginPage from '@/views/CakePage/LoginPage.vue'
import SignUpPage from '@/views/CakePage/SignUpPage.vue'
import test from '@/views/CakePage/test.vue'
import BookingReadPage from '@/views/boardPage/BookingReadPage.vue'
import BookingModifyPage from '@/views/boardPage/BookingModifyPage.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
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
    path: '/test',
    name: 'test',
    component: test
  }
  ,
  {
    path: '/bookingReadPage/:bookingNo',
    name: 'BookingReadPage',
    components: {
      default: BookingReadPage
    },
    props: {
      default: true
    }
  }
  ,
  {
    path: '/bookingModifyPage',
    name: 'BookingModifyPage',
    components: {
      default: BookingModifyPage
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
