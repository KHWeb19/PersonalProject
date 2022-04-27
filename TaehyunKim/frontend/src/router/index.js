import Vue from 'vue'
import VueRouter from 'vue-router'
import HomePage from '../views/HomePage'
import store from "../store/index.js"

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomePage
  },
  {
    path: '/signup',
    name: 'signup',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/UserPage/SignUp.vue')
  },
  {
    path: '/dummy',
    name: 'dummy',
    component: () => import('../views/DummyView.vue')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/UserPage/LogInPage')
  },
  {
    path: '/mypage',
    name: 'mypage',
    component: () => import('../views/UserPage/MyPage')
  },
  {
    path: '/duptest',
    name: 'test',
    component: () => import('../views/DupTest')
  },
  {
    path: '/listpost',
    name: 'listpost',
    component: () => import('../views/PostPage/ListPost')
  },
  {
    path: '/createpost',
    name: 'createpost',
    component: () => import('../views/PostPage/CreatePost')
  },
  {
    path: '/readpost/:no',
    name: 'readpost',
    component: () => import('../views/PostPage/ReadPost'),
    props: true
  },
  {
    path: '/modifypost/:no',
    name: 'modifypost',
    component: () => import('../views/PostPage/ModifyPost')
  },
  {
    path: '*',
    name: "notFound",
    component: () => import('../views/NotFound.vue')
  }
]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach(function(to,from,next){
  store.dispatch('validate_login')
  next()
})

export default router
