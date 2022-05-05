import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import SearchView from "@/views/SearchView";
import BoardView from "@/views/board/BoardView";
import BoardReadView from "@/views/board/BoardReadView";
import BoardModifyView from "@/views/board/BoardModifyView";
import MyPage from "@/views/myPage/MyPage";
import MyPageModify from "@/views/myPage/MyPageModify";
import MyPagePlaceList from "@/views/myPage/MyPagePlaceList";
import MyPageDiary from "@/views/myPage/MyPageDiary";
import MyPageDiaryRead from "@/views/myPage/MyPageDiaryRead";
import MyPageDiaryModify from "@/views/myPage/MyPageDiaryModify";
import MyPageKeepADiary from "@/views/myPage/MyPageKeepADiary";
import LoginPage from "@/views/login/LoginPage";
import RegisterPage from "@/views/login/RegisterPage";
import IdPwSearchPage from "@/views/login/IdPwSearchPage";
import PlanListView from "@/views/plan/PlanListView";
import PlanView from "@/views/plan/PlanView";
import ChangePw from "@/views/login/ChangePw";
import PlanDayView from "@/views/plan/PlanDayView"
import PlanMapListView from "@/views/plan/map/PlanMapListView"

Vue.use(VueRouter)

const routes = [
  {
    path: '/plan',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/search',
    name: 'SearchView',
    component: SearchView
  },
  {
    path: '/board',
    name: 'BoardView',
    component: BoardView
  },
  {
    path: '/myPage',
    name: 'MyPage',
    component: MyPage
  },
  {
    path: '/loginPage',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/register',
    name: 'RegisterPage',
    component: RegisterPage
  },
  {
    path: '/idPwSearch',
    name: 'IdPwSearchPage',
    component: IdPwSearchPage
  },
  {
    path: '/planListPage',
    name: 'PlanListView',
    component: PlanListView,
    props: true
  },
  {
    path: '/PlanPage/:day',
    name: 'PlanView',
    component: PlanView,
    props: true
  },
  {
    path: '/changePw',
    name: 'ChangePw',
    component: ChangePw,
    props: true
  },
  {
    path: '/PlanDay/:day',
    name: 'PlanDayView',
    component: PlanDayView,
    props: true
  },
  {
    path: '/boardRead/:boardNo',
    name: 'BoardReadView',
    component: BoardReadView,
    props: true
  },
  {
    path: '/boardModify/:boardNo',
    name: 'BoardModifyView',
    component: BoardModifyView,
    props: true
  },
  {
    path: '/planMapList/:planNo',
    name: 'PlanMapListView',
    component: PlanMapListView,
    props: true
  },
  {
    path: '/myPageModify',
    name: 'MyPageModify',
    component: MyPageModify
  },
  {
    path: '/myPagePlaceList',
    name: 'MyPagePlaceList',
    component: MyPagePlaceList
  },
  {
    path: '/myPageDiary',
    name: 'MyPageDiary',
    component: MyPageDiary
  },
  {
    path: '/keepADiary',
    name: 'MyPageKeepADiary',
    component: MyPageKeepADiary
  },
  {
    path: '/diaryRead/:diaryNo',
    name: 'MyPageDiaryRead',
    component: MyPageDiaryRead,
    props: true
  },
  {
    path: '/myPageDiaryModify/:diaryNo',
    name: 'MyPageDiaryModify',
    component: MyPageDiaryModify,
    props: true
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
