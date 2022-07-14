import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

// 메인홈
import MainPage from '@/views/main/MainPage.vue'

// 로그인
import MemberLogin from '@/views/member/MemberLogin.vue'
// 마이페이지
import UserList from '@/views/member/UserList.vue'
import UserReadPage from '@/views/member/UserReadPage.vue'
import UserModifyPage from '@/views/member/UserModifyPage.vue'
import MyReservation from '@/views/member/MyReservation.vue'
import ReservationReadPage from '@/views/member/ReservationReadPage.vue'


// 관리자
import MemberListPage from '@/views/manager/MemberListPage.vue'
import MemberReadPage from '@/views/manager/MemberReadPage.vue'
import MemberModifyPage from '@/views/manager/MemberModifyPage.vue'
import BookingListPage from '@/views/manager/BookingListPage.vue'
import BookingReadPage from '@/views/manager/BookingReadPage.vue'


// 회원가입
import MemberRegister from '@/views/member/MemberRegister.vue'

//카테고리
import ServicePage from '@/views/category/ServicePage.vue'
import ReservationPage from '@/views/category/ReservationPage.vue'

// board
import BoardListPage from '@/views/category/board/BoardListPage.vue'
import BoardRegisterPage from '@/views/category/board/BoardRegisterPage.vue'
import BoardReadPage from '@/views/category/board/BoardReadPage.vue'
import BoardModifyPage from '@/views/category/board/BoardModifyPage.vue'

// room
import SelectRoom from '@/views/category/rooms/SelectRoom.vue'
import VioletRoom from '@/views/category/rooms/VioletRoom.vue'
import LilyRoom from '@/views/category/rooms/LilyRoom.vue'
import RoseRoom from '@/views/category/rooms/RoseRoom.vue'
import SunflowerRoom from '@/views/category/rooms/SunflowerRoom.vue'

// 예약하기
import BookingPage from '@/views/BookingPage.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/hawul',
    name: 'MainPage',
    components: {
      default: MainPage
    }
  },
  {
    path: '/login',
    name: 'MemberLogin',
    components: {
      default: MemberLogin
    }
  },
  {
    path: '/userList',
    name: 'UserList',
    components: {
      default: UserList
    }
  },
  {
    path: '/myReservation',
    name: 'MyReservation',
    components: {
      default: MyReservation
    }
  },
  {
    path: '/book/:bookNo',
    name: 'ReservationReadPage',
    components: {
      default: ReservationReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/member/:memberNo/editpage',
    name: 'UserModifyPage',
    components: {
      default: UserModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/member/:memberNo',
    name: 'UserReadPage',
    components: {
      default: UserReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/memberRegister',
    name: 'MemberRegister',
    components: {
      default: MemberRegister
    }
  },
  {
    path: '/bookingPage',
    name: 'BookingPage',
    components: {
      default: BookingPage
    }
  },
  {
    path: '/reservationPage',
    name: 'ReservationPage',
    components: {
      default: ReservationPage
    }
  },
  {
    path: '/rooms',
    name: 'SelectRoom',
    components: {
      default: SelectRoom
    }
  },
  {
    path: '/roseRoom',
    name: 'RoseRoom',
    components: {
      default: RoseRoom
    }
  },
  {
    path: '/sunflowerRoom',
    name: 'SunflowerRoom',
    components: {
      default: SunflowerRoom
    }
  },
  {
    path: '/violetRoom',
    name: 'VioletRoom',
    components: {
      default: VioletRoom
    }
  },
  {
    path: '/lilyRoom',
    name: 'LilyRoom',
    components: {
      default: LilyRoom
    }
  },
  {
    path: '/servicePage',
    name: 'ServicePage',
    components: {
      default: ServicePage
    }
  },
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    }
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    }
  },
  {
    path: '/memberList',
    name: 'MemberListPage',
    components: {
      default: MemberListPage
    }
  },
  {
    path: '/manager/member/:memberNo',
    name: 'MemberReadPage',
    components: {
      default: MemberReadPage
    }
  },
  {
    path: '/member/:memberNo/edit',
    name: 'MemberModifyPage',
    components: {
      default: MemberModifyPage
    }
  },
  {
    path: '/bookingList',
    name: 'BookingListPage',
    components: {
      default: BookingListPage
    }
  },
  {
    path: '/room/:bookNo',
    name: 'BookingReadPage',
    components: {
      default: BookingReadPage
    }
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router