import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/signup',
    name: 'signup',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/SignUpPage.vue')
  },
  {
    path: '/dummy',
    name: 'dummy',
    component: () => import('../views/DummyView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/LogInPage')
  },
  {
    path: '/signout',
    name: 'signout',
    component: () => import('../views/SignOutPage')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
