import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import SearchView from "@/views/SearchView";
import BoardView from "@/views/BoardView";
import MyPage from "@/views/MyPage";
import LoginPage from "@/views/login/LoginPage";
import RegisterPage from "@/views/login/RegisterPage";
import IdPwSearchPage from "@/views/login/IdPwSearchPage";

Vue.use(VueRouter)

const routes = [
  {
    path: '/plan',
    name: 'home',
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
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
