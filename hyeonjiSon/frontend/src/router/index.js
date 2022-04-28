import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/HomeView.vue'

import MemberLoginPage from '@/views/jpaMember/MemberLoginPage.vue'
import MemberRegisterPage from '@/views/jpaMember/MemberRegisterPage.vue'
import MemberMyPage from '@/views/jpaMember/MemberMyPage.vue'

import ProjectIntroducePage from '@/views/introduce/ProjectIntroducePage.vue'

import RecycleGuideMainPage from '@/views/recycleGuide/RecycleGuideMainPage.vue'
import GuideBoxPage from '@/views/recycleGuide/GuideBoxPage.vue'
import GuideSearchPage from '@/views/recycleGuide/GuideSearchPage.vue'

import LivingTipBoardList from '@/views/livingTip/LivingTipBoardList.vue'
import LivingTipSearchList from '@/views/livingTip/LivingTipSearchList.vue'
import TipRegisterPage from '@/views/livingTip/TipRegisterPage.vue'
import TipReadPage from '@/views/livingTip/TipReadPage.vue'
import TipModifyPage from '@/views/livingTip/TipModifyPage.vue'

import StoreBoardListPage from '@/views/findStore/StoreBoardListPage.vue'
import StoreSearchPage from '@/views/findStore/StoreSearchPage.vue'

import DonationInfoPage from '@/views/donateInfo/DonationInfoPage.vue'

import EmailReportPage from '@/views/emailReport/EmailReportPage.vue'


Vue.use(VueRouter)

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => {
		if (err.name !== 'NavigationDuplicated') throw err;
	});
};

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
    path: '/memberMyPage',
    name: 'memberMyPage',
    component: MemberMyPage 
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
    path: '/guideBoxPage',
    name: 'guideBoxPage',
    component: GuideBoxPage
  },
  {
    path: '/guideSearchPage',
    name: 'guideSearchPage',
    component: GuideSearchPage
  },
  
  {
    path: '/livingTipBoardList',
    name: 'livingTipBoardList',
    component: LivingTipBoardList
  },
  {
    path: '/livingTipSearchList/:keyWord',
    name: 'livingTipSearchList',
    components: {
      default: LivingTipSearchList
    },
    props: {
      default: true
    }
  },
  {
    path: '/tipRegisterPage',
    name: 'tipRegisterPage',
    component: TipRegisterPage
  },
  {
    path: '/tipReadPage/:boardNo',
    name: 'TipReadPage',
    components: {
      default: TipReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/tipModifyPage/:boardNo',
    name: 'TipModifyPage',
    components: {
      default: TipModifyPage
    },
    props: {
      default: true
    }
  },


  {
    path: '/storeBoardListPage',
    name: 'storeBoardListPage',
    component: StoreBoardListPage
  },
  {
    path: '/storeSearchPage/:keyWord',
    name: 'storeSearchPage',
    components: {
      default: StoreSearchPage
    },
    props: {
      default: true
    }
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
