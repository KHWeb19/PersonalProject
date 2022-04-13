import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '@/views/MainPage/HomeView.vue'
import AwesomeSwiperTestPage from '@/views/testView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'homeView',
    component: HomeView
  },
  {
    path: '/awesomeSwiperTest',
    name: 'AwesomeSwiperTestPage',
    components: {
      default: AwesomeSwiperTestPage
    },
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
