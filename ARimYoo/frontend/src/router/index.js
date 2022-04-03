import Vue from 'vue'
import VueRouter from 'vue-router'

import EnterVellup from '../views/EnterVellup.vue'
import MainVellupPage from '../views/MainVellupPage.vue'
import JoinPage from '../views/JoinPage.vue'
import JoinPage2 from '../views/JoinPage2.vue'
import MemberModifyPage from '../views/MemberModifyPage.vue'
import CommunityPage from '../views/CommunityPage.vue'


Vue.use(VueRouter)

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
        path: '/memberModify',
        name: 'MemberModifyPage',
        component: MemberModifyPage
    },
    {
        path: '/community',
        name: 'CommunityPage',
        component: CommunityPage
    }

  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
