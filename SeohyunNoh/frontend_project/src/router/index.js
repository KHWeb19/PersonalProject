import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store'
import Home from '../views/Home.vue'

import MainPage from '@/views/project/MainPage.vue'
import LoginPage from '@/views/project/LoginPage.vue'
import JoinPage from '@/views/project/JoinPage.vue'
import MyPage from '@/views/project/MyPage.vue'

import AdminPage from '@/views/admin/AdminPage.vue'

import AddCategory from '@/views/category/AddCategory.vue'
import Category from '@/views/category/Category.vue'
import ListProducts from '@/views/category/ListProducts.vue'
import EditCategory from '@/views/category/EditCategory.vue'

import Product from '@/views/product/Product.vue'
import AddProduct from '@/views/product/AddProduct.vue'
import EditProduct from '@/views/product/EditProduct.vue'
import ShowDetails from '@/views/product/ShowDetails.vue'
import TopProducts from '@/views/product/TopProducts.vue'

import Cart from '@/views/cart/Cart.vue'


import LookBookPage from '@/views/project/LookBookPage.vue'

import NoticeListPage from '@/views/notice/NoticeListPage.vue'
import NoticeReadPage from '@/views/notice/NoticeReadPage.vue'
import NoticeRegisterPage from '@/views/notice/NoticeRegisterPage.vue'
import NoticeModifyPage from '@/views/notice/NoticeModifyPage.vue'

import QnAListPage from '@/views/qna/QnAListPage.vue'
import QnARegisterPage from '@/views/qna/QnARegisterPage.vue'
import QnAReadPage from '@/views/qna/QnAReadPage.vue'
import QnAModifyPage from '@/views/qna/QnAModifyPage.vue'



// import WomenOuterCategoryPage from '@/views/womenCategory/WomenOuterCategoryPage.vue'
// import ProductDetailPage from '@/views/womenCategory/ProductDetailPage.vue'




Vue.use(VueRouter)

// const rejectAuthUser = (to, from, next) => {
//   if(store.state.isLogin === true) {
//     //이미 로그인된 유저니까 막아야하는 페이지 
//     alert('이미 로그인을 하였습니다.')
//     next('/mainPage')
//   }
//   else {
//     next()
//   }
// }

const onlyAuthUser = (to, from, next) => {
  if(store.state.isLogin === false) {
    //아직 로그인이 안된 유저니까 막아야하는 페이지 
    alert('로그인이 필요한 서비스입니다.')
    next('/loginPage')
  }
  else {
    next()
  }
}

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/mainPage',
    name: 'MainPage',
    component: MainPage
  },
  {
    path: '/loginPage',
    name: 'LoginPage',
    beforeEnter: (to, from, next) => {
      if(store.state.isLogin === true) {
        //이미 로그인된 유저니까 막아야하는 페이지 
        alert('이미 로그인을 하였습니다.')
        next('/mainPage')
      }
      else {
        next()
      }
    },
    component: LoginPage
  },
  {
    path: '/joinPage',
    name: 'JoinPage',
    component: JoinPage
  },
  {
    path: '/myPage',
    name: 'MyPage',
    beforeEnter: onlyAuthUser,
    component: MyPage
  },
  {
    path: '/adminPage',
    name: 'AdminPage',
    component: AdminPage
  },
  {
    path: '/addCategory',
    name: 'AddCategory',
    component: AddCategory
  },
  {
    path: '/category',
    name: 'Category',
    component: Category
  },
  {
    path: '/listProducts/:id',
    name: 'ListProducts',
    components: {
      default: ListProducts
    },
    props: {
      default: true
    }
  },
  {
    path: '/editCategory/:id',
    name: 'EditCategory',
    components: {
      default: EditCategory
    },
    props: {
      default: true
    }
  },
  {
    path: '/addProduct',
    name: 'AddProduct',
    component: AddProduct
  },
  {
    path: '/product',
    name: 'Product',
    component: Product
  },
  {
    path: '/topProducts',
    name: 'TopProducts',
    component: TopProducts
  },
  {
    path: '/editProduct/:id',
    name: 'EditProduct',
    components: {
      default: EditProduct
    },
    props: {
      default: true
    }
  },
  {
    path: '/showDetails/:id',
    name: 'ShowDetails',
    components: {
      default: ShowDetails
    },
    props: {
      default: true
    }
  },
  {
    path: '/cart',
    name: 'Cart',
    component: Cart
  },
  {
    path: '/noticeListPage',
    name: 'NoticeListPage',
    component: NoticeListPage
  },
  {
    path: '/noticeReadPage/:boardNo',
    name: 'NoticeReadPage',
    components: {
      default: NoticeReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/noticeRegisterPage',
    name: 'NoticeRegisterPage',
    component: NoticeRegisterPage
  },
  {
    path: '/noticeModifyPage/:boardNo',
    name: 'NoticeModifyPage',
    components: {
      default: NoticeModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/qnaListPage',
    name: 'QnAListPage',
    beforeEnter: onlyAuthUser,
    component: QnAListPage
  },
  {
    path: '/qnaRegisterPage',
    name: 'QnARegisterPage',
    component: QnARegisterPage
  },
  {
    path: '/qnaReadPage/:qnaNo',
    name: 'QnAReadPage',
    components: {
      default: QnAReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/qnaModifyPage/:qnaNo',
    name: 'QnAModifyPage',
    components: {
      default: QnAModifyPage
    },
    props: {
      default: true
    }
  },
  // {
  //   path: '/womenOuterCategoryPage',
  //   name: 'WomenOuterCategoryPage',
  //   component: WomenOuterCategoryPage
  // },
  // {
  //   path: '/productDetail',
  //   name: 'ProductDetailPage',
  //   component: ProductDetailPage
  // },
  {
    path: '/lookBookPage',
    name: 'LookBookPage',
    component: LookBookPage
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
