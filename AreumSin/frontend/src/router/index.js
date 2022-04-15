import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import SearchView from "@/views/SearchView";
import BoardView from "@/views/BoardView";
import MyPage from "@/views/MyPage";
import LoginPage from "@/views/login/LoginPage";
import RegisterPage from "@/views/login/RegisterPage";
import IdPwSearchPage from "@/views/login/IdPwSearchPage";
import PlanListView from "@/views/plan/PlanListView";
import PlanView from "@/views/plan/PlanView";
import ChangePw from "@/views/login/ChangePw";

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
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
