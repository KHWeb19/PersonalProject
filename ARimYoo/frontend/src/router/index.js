import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store/index'

import EnterVellup from '../views/main/EnterVellup.vue'
import MainVellupPage from '../views/main/MainVellupPage.vue'
import JoinPage from '../views/main/JoinPage.vue'
import JoinPage2 from '../views/main/JoinPage2.vue'
import MyPage from '../views/my/MyPage.vue'
import MyWith from '../views/my/MyWith.vue'

import CommunityPage from '../views/board/communityBoard/CommunityPage.vue'
import CommunityWritePage from '../views/board/communityBoard/CommunityWritePage.vue'
import CommunityReadPage from '../views/board/communityBoard/CommunityReadPage.vue'
import CommunityModifyPage from '../views/board/communityBoard/CommunityModifyPage.vue'

import ReviewPage from '../views/board/review/ReviewPage.vue'
import ReviewWritePage from '../views/board/review/ReviewWritePage.vue'
import ReviewReadPage from '../views/board/review/ReviewReadPage.vue'
import ReviewModifyPage from '../views/board/review/ReviewModifyPage.vue'

import StudyPage from '../views/board/study/StudyPage.vue'
import StudyWritePage from '../views/board/study/StudyWritePage.vue'
import StudyReadPage from '../views/board/study/StudyReadPage.vue'
import StudyModifyPage from '../views/board/study/StudyModifyPage.vue'

import ProjectPage from '../views/board/project/ProjectPage.vue'
import ProjectWritePage from '../views/board/project/ProjectWritePage.vue'
import ProjectReadPage from '../views/board/project/ProjectReadPage.vue'
import ProjectModifyPage from '../views/board/project/ProjectModifyPage.vue'

import MarketPage from '../views/board/market/MarketPage.vue'
import MarketWritePage from '../views/board/market/MarketWritePage.vue'
import MarketReadPage from '../views/board/market/MarketReadPage.vue'
import MarketModifyPage from '../views/board/market/MarketModifyPage.vue'

Vue.use(VueRouter)

const requireLogin = () => (to, from, next) => {
    if (store.state.token !== null) {
        return next()
    } else {
        alert('로그인이 필요한 서비스입니다.')
        this.$router.push('/main')
    }
} 

// const writerCheck = () => (to, from, next) => {
//     alert('해당 방식으로는 접근이 불가능합니다.')
//     return next('/main')
    
// }

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
        path: '/myWith',
        name: 'MyWith',
        component: MyWith,
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
        component: CommunityWritePage,
        beforeEnter: requireLogin()
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
        },
        beforeEnter: requireLogin()
    },
    {
        path: '/community/modify/:boardNo',
        name: 'CommunityModifyPage',
        components: {
            default: CommunityModifyPage
        },
        props: {
            default: true
        },
        beforeEnter: requireLogin()
    },
    {
        path: '/review',
        name: 'ReviewPage',
        component: ReviewPage,
        beforeEnter: requireLogin()
    },
    {
        path: '/review/write',
        name: 'ReviewWritePage',
        component: ReviewWritePage,
        beforeEnter: requireLogin()
    },
    {
        path: '/review/:reviewNo',
        name: 'ReviewReadPage',
        components: {
            default:
                ReviewReadPage
        },
        props: {
            default: true
        },
        beforeEnter: requireLogin()
    },
    {
        path: '/review/modify/:reviewNo',
        name: 'ReviewModifyPage',
        components: {
            default: ReviewModifyPage
        },
        props: {
            default: true
        },
        beforeEnter: requireLogin()
    },
    {
        path: '/study',
        name: 'StudyPage',
        component: StudyPage,
        beforeEnter: requireLogin()
    },
    {
        path: '/study/write',
        name: 'StudyWritePage',
        component: StudyWritePage,
        beforeEnter: requireLogin()
    },
    {
        path: '/study/:studyNo',
        name: 'StudyReadPage',
        components: {
            default:
                StudyReadPage
        },
        props: {
            default: true
        },
        beforeEnter: requireLogin()
    },
    {
        path: '/study/modify/:studyNo',
        name: 'StudyModifyPage',
        components: {
            default: StudyModifyPage
        },
        props: {
            default: true
        },
        beforeEnter: requireLogin()
    },
    {
        path: '/project',
        name: 'ProjectPage',
        component: ProjectPage,
        beforeEnter: requireLogin()
    },
    {
        path: '/project/write',
        name: 'ProjectWritePage',
        component: ProjectWritePage,
        beforeEnter: requireLogin()
    },
    {
        path: '/project/:projectNo',
        name: 'ProjectReadPage',
        components: {
            default:
                ProjectReadPage
        },
        props: {
            default: true
        },
        beforeEnter: requireLogin()
    },
    {
        path: '/project/modify/:projectNo',
        name: 'ProjectModifyPage',
        components: {
            default: ProjectModifyPage
        },
        props: {
            default: true
        },
        beforeEnter: requireLogin()
    },
    {
        path: '/market',
        name: 'MarketPage',
        component: MarketPage,
        beforeEnter: requireLogin()
    },
    {
        path: '/market/write',
        name: 'MarketWritePage',
        component: MarketWritePage,
        beforeEnter: requireLogin()
    },
    {
        path: '/market/:boardNo',
        name: 'MarketReadPage',
        components: {
            default:
                MarketReadPage
        },
        props: {
            default: true
        },
        beforeEnter: requireLogin()
    },
    {
        path: '/market/modify/:boardNo',
        name: 'MarketModifyPage',
        components: {
            default: MarketModifyPage
        },
        props: {
            default: true
        },
        beforeEnter: requireLogin()
    },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
