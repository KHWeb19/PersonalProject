import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '@/views/Home.vue'
import productList from '@/components/product/ProductList.vue'
import uploadProduct from '@/components/product/UploadProduct.vue'




Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/productList',
    name: 'productList',
    component: productList
  },
  {
    path: '/uploadProduct',
    name: 'uploadProduct',
    component: uploadProduct
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
