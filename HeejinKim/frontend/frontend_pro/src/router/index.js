import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import MainPage from '@/views/main/MainPage.vue'
//import RegisterPage from '@/views/login/RegisterPage.vue'
import LoginPage from '@/views/login/LoginPage.vue'
import MemberInfoPage from '@/views/main/MemberInfoPage.vue'
import BoardList from '@/views/board/community/BoardList.vue'
import  BoardRegister from '@/views/board/community/BoardRegister.vue'
import  BoardRead from '@/views/board/community/BoardRead.vue'
import  BoardModify from '@/views/board/community/BoardModify.vue'
import  ReservationPage from '@/views/board/reservation/ReservationPage.vue'
//import ReservationSeatForm from '@/components/board/reservation/ReservationSeatForm.vue'


//import ReservationSeat from '@/components/board/reservation/ReservationSeat.vue'
import ReservationFinish from '@/components/board/reservation/ReservationFinish.vue'
import ReservationCheckPage from '@/views/board/reservation/ReservationCheckPage.vue';

Vue.use(VueRouter)

const routes = [
  {
    path: '/Home',
    name: 'Home',
    component: Home
  },
  {
    path: '/mainPage',
    name: 'MainPage',
    components: {
       MainPage
    } 
  },
  /*
  {
    path: '/register',
    name: 'RegisterPage',
    component: RegisterPage
  },*/
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/memberInfo',
    name: 'MemberInfoPage',
    components: {
       MemberInfoPage
    }
  },
  {
    path: '/communityBoard',
    name: 'BoardList',
    component: 
      BoardList
    
  },
  {
    path: '/community/register',
    name: 'BoardRegister',
    component: BoardRegister
},
{
  path: '/community/read/:boardNo',
  name: 'BoardRead',
  components: {
    default:BoardRead
  },
  props: {
    default: true
  }
},
{
  path: '/community/modify/:boardNo',
  name: 'BoardModify',
  components: {
    default:BoardModify
  },
  props: {
    default: true
  }
},

{
  path: '/reservation',
  name: 'ReservationPage',
  components:{
    
    default:ReservationPage
  } 
    
  
},
/*
{
  path: '/reservation',
  name: 'ReservationSeatForm',
  components:{
    
    default:ReservationSeatForm
  } 
    
  
},*/

  //{ path: '/select', name: 'ReservationSeat', components:{default : ReservationSeat}},
  { path: '/finish', name: 'ReservationFinish', components:{default: ReservationFinish} },
  { path: '/check', name: 'ReservationCheckPage', components: {default:ReservationCheckPage} },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
