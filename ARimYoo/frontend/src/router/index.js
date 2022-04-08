import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store/index'

import EnterVellup from '../views/main/EnterVellup.vue'
import MainVellupPage from '../views/main/MainVellupPage.vue'
import JoinPage from '../views/main/JoinPage.vue'
import JoinPage2 from '../views/main/JoinPage2.vue'
import MyPage from '../views/my/MyPage.vue'

import CommunityPage from '../views/board/CommunityPage.vue'
import CommunityWritePage from '../views/board/CommunityWritePage.vue'
import CommunityReadPage from '../views/board/CommunityReadPage.vue'
import CommunityModifyPage from '../views/board/CommunityModifyPage.vue'

Vue.use(VueRouter)

const requireLogin = () => (to, from, next) => {
    if (store.state.token !== null) {
        return next()
    } else {
        alert('로그인이 필요한 서비스입니다.')
    }
} 

const routes = [
  {
    path: '/',
    name: 'EnterVellup',
    component: EnterVellup
  },
  {
    path: '/main',
    name: 'MainVellupPage',
    component: MainVellupPage
  },

  {
    path: '/join',
    name: 'JoinPage',
    component: JoinPage
  },
  {
    path: '/join2',
    name: 'JoinPage2',
    component: JoinPage2
    },
    {
        path: '/myPage',
        name: 'MyPage',
        component: MyPage,
        beforeEnter: requireLogin()
    },
    {
        path: '/community',
        name: 'CommunityPage',
        component: CommunityPage,
        beforeEnter: requireLogin()
    },
    {
        path: '/community/write',
        name: 'CommunityWritePage',
        component: CommunityWritePage
    },
    {
        path: '/community/:boardNo',
        name: 'CommunityReadPage',
        components: {
            default:
                CommunityReadPage
        },
        props: {
            default: true
        }
    },
    {
        path: '/community/modify/:boardNo',
        name: 'CommunityModifyPage',
        components: {
            default: CommunityModifyPage
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
