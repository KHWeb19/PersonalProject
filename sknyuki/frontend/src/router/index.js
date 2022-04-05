import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/MainPage/HomeView.vue'
import K1CheckBrandView from '@/views/K1CheckBrandVeiw/K1CheckBrandView.vue'
import K1CheckBrandReadPage from '@/views/K1CheckBrandVeiw/K1CheckBrandReadPage.vue'
import K1QuestionReadPage from '@/views/K1QuestionVeiw/K1QuestionReadPage.vue'
import K1QuestionView from '@/views/K1QuestionVeiw/K1QuestionView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'homeView',
    component: HomeView
  },
  {
    path: '/K1CheckBrandView',
    name: 'K1CheckBrandView',
    component: K1CheckBrandView
  },
  {
    path:'/K1CheckBrandReadPage',
    name:'K1CheckBrandReadPage',
    component: K1CheckBrandReadPage
  },
  {
    path:'/K1QuestionReadPage',
    name:'K1QuestionReadPage',
    component: K1QuestionReadPage
  },
  {
    path:'/K1QuestionView',
  name:'K1QuestionView',
  component: K1QuestionView
}
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
