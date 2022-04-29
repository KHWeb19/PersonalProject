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
import BookingReadPage from '@/views/boardPage/BookingReadPage.vue'
import BookingModifyPage from '@/views/boardPage/BookingModifyPage.vue'
import BeforeBooking from '@/views/boardNotice/BeforeBooking.vue'
import BeforeConfirm from '@/views/boardNotice/BeforeConfirm.vue'
import MyPageReview from '@/views/myPage/MyPageReview.vue'
import MyPageBooking from '@/views/myPage/MyPageBooking.vue'
import ManagerPageMember from '@/views/managerPage/ManagerPageMember.vue'
import ManagerPageCake from '@/views/managerPage/ManagerPageCake.vue'
import ManagerPageBooking from '@/views/managerPage/ManagerPageBooking.vue'


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
    path: '/myPage/:id',
    name: 'MyPage',
    components: {
      default: MyPage
    },
    props: {
      default: true
    }
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
    path: '/bookingModifyPage/:bookingNo',
    name: 'BookingModifyPage',
    components: {
      default: BookingModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/beforeBooking',
    name: 'BeforeBooking',
    component: BeforeBooking
  }
  ,
  {
    path: '/beforeConfirm',
    name: 'BeforeConfirm',
    component: BeforeConfirm
  }
  ,
  {
    path: '/myPageReview/:id',
    name: 'MyPageReview',
    components: {
      default: MyPageReview
    },
    props: {
      default: true
    }
  }
  ,
  {
    path: '/myPageBooking/:id',
    name: 'MyPageBooking',
    components: {
      default: MyPageBooking
    },
    props: {
      default: true
    }
  }
  ,
  {
    path: '/managerPageCake/:id',
    name: 'ManagerPageCake',
    components: {
      default: ManagerPageCake
    },
    props: {
      default: true
    }
  }
  ,
  {
    path: '/managerPageMember/:id',
    name: 'ManagerPageMember',
    components: {
      default: ManagerPageMember
    },
    props: {
      default: true
    }
  }
  ,
  {
    path: '/managerPageBooking/:id',
    name: 'ManagerPageBooking',
    components: {
      default: ManagerPageBooking
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
