import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue'

import MemberLoginPage from '@/views/jpaMember/MemberLoginPage.vue'
import MemberRegisterPage from '@/views/jpaMember/MemberRegisterPage.vue'

import ProjectIntroducePage from '@/views/introduce/ProjectIntroducePage.vue'

import RecycleGuideMainPage from '@/views/recycleGuide/RecycleGuideMainPage.vue'

import LivingTipBoardPage from '@/views/livingTip/LivingTipBoardPage.vue'

import BoardStorePage from '@/views/findStore/BoardStorePage.vue'

import DonationInfoPage from '@/views/donateInfo/DonationInfoPage.vue'

import EmailReportPage from '@/views/emailReport/EmailReportPage.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/memberLoginPage',
    name: 'memberLoginPage',
    component: MemberLoginPage 
  },
  {
    path: '/memberRegisterPage',
    name: 'memberRegisterPage',
    component: MemberRegisterPage 
  },
  {
    path: '/projectIntroducePage',
    name: 'projectIntroducePage',
    component: ProjectIntroducePage 
  },
  {
    path: '/recycleGuideMainPage',
    name: 'recycleGuideMainPage',
    component: RecycleGuideMainPage
  },
  {
    path: '/livingTipBoardPage',
    name: 'livingTipBoardPage',
    component: LivingTipBoardPage
  },
  {
    path: '/boardStorePage',
    name: 'boardStorePage',
    component: BoardStorePage
  },
  {
    path: '/donationInfoPage',
    name: 'donationInfoPage',
    component: DonationInfoPage
  },
  {
    path: '/emailReportPage',
    name: 'emailReportPage',
    component: EmailReportPage
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
