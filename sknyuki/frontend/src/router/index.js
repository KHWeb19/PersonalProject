import Vue from 'vue'
import VueRouter from 'vue-router'
import VuetifyTemplateList from '@/views/VuetifyTemplateList.vue'
import HomeView from '@/views/MainPage/HomeView.vue'
import K1CheckBrandView from '@/views/K1CheckBrandVeiw/K1CheckBrandView.vue'
import K1CheckBrandReadPage from '@/views/K1CheckBrandVeiw/K1CheckBrandReadPage.vue'
import K1QuestionReadPage from '@/views/K1QuestionVeiw/K1QuestionReadPage.vue'
import K1QuestionView from '@/views/K1QuestionVeiw/K1QuestionView.vue'
import K1CheckBrandRegisterPage from '@/views/K1CheckBrandVeiw/K1CheckBrandRegisterPage.vue'
import K1CheckBrandModifyPage from '@/views/K1CheckBrandVeiw/K1CheckBrandModifyPage.vue'
import K1QuestionRegisterPage from '@/views/K1QuestionVeiw/K1QuestionRegisterPage'
import K2ProductView from '@/views/K2ProductView/K2ProductView'
import K1QuestionModifyPage from '@/views/K1QuestionVeiw/K1QuestionModifyPage.vue'
import MyPage from '@/views/member/MyPage'
import K2ProductRegisterPage from '@/views/K2ProductView/K2ProductRegisterPage.vue'
import K2ProductReadPage from '@/views/K2ProductView/K2ProductReadPage.vue'
import K2ProductModifyPage from '@/views/K2ProductView/K2ProductModifyPage.vue'
import K2SoldReadPage from '@/views/K2SoldView/K2SoldReadPage.vue'
import K2SoldView from '@/views/K2SoldView/K2SoldView.vue'
import K3basketReadPage from '@/views/basketVeiw/K3basketReadPage.vue'
Vue.use(VueRouter)

const routes = [
  { 
    path: '/test',
  name:'VuetifyTemplateList',
  component:VuetifyTemplateList
  },
  {
    path: '/',
    name: 'homeView',
    component: HomeView
  },
  {
    path: '/K1CheckBrandView',
    name: 'K1CheckBrandView',
    component: K1CheckBrandView,
    props:true
  },
  
  {
    path:'/K1CheckBrandReadPage/:boardNo',
    name:'K1CheckBrandReadPage',
    components: {
      default: K1CheckBrandReadPage
  },
  props: {
    default: true
  }
},
  {
    path:'/K1QuestionReadPage/:boardNo',
    name:'K1QuestionReadPage',
    components: {
      default: K1QuestionReadPage
  },
  props: {
    default: true
  }
  },
  {
  path:'/K1QuestionView',
  name:'K1QuestionView',
  component: K1QuestionView
},
{
  path:'/K1CheckBrandRegisterPage',
  name:'K1CheckBrandRegisterPage',
  component:K1CheckBrandRegisterPage
},
{
  path:'/K1CheckBrandModifyPage/:boardNo',
  name:'K1CheckBrandModifyPage',
  components:{
    default:K1CheckBrandModifyPage
},
props:{
  default: true
}
},
{
  path:'/K1QuestionRegisterPage',
  name:'K1QuestionRegisterPage',
  component:K1QuestionRegisterPage
},
{
  path:'/K2ProductView',
  name:'K2ProductView',
  component:K2ProductView
},
{
  path: '/MyPage',
  name: 'MyPage',
  component: MyPage
},
{
path: '/K1QuestionModifyPage/:boardNo',
  name: 'K1QuestionModifyPage',
  components:{
    default:K1QuestionModifyPage
},
props:{
  default: true
}
},
{
  path: '/K2ProductRegisterPage',
  name: 'K2ProductRegisterPage',
  component: K2ProductRegisterPage
},
{
  path:'/K2ProductReadPage/:boardNo',
  name:'K2ProductReadPage',
  components: {
    default: K2ProductReadPage
},
props: {
  default: true
}
},
{
  path: '/K2ProductModifyPage/:boardNo',
    name: 'K2ProductModifyPage',
    components:{
      default:K2ProductModifyPage
  },
  props:{
    default: true
  }
  },
  {
    path:'/K2SoldReadPage/:boardNo',
    name:'K2SoldReadPage',
    components: {
      default: K2SoldReadPage
  },
  props: {
    default: true
  }
  },
  {
    path:'/K2SoldView',
    name:'K2SoldView',
    component:K2SoldView
  },
  {
    path:'/K3basketReadPage/:basketNo',
    name:'K3basketReadPage',
    components: {
      default: K3basketReadPage
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
