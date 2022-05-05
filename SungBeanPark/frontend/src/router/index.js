import Vue from "vue"
import VueRouter from "vue-router"
import MemberInfoPage from "../views/Account/MemberInfoPage.vue"
import PasswordPage from "../views/Account/PasswordPage.vue"
import LoginPage from "../views/Account/LoginPage.vue"
import SignPage from "../views/Account/SignPage.vue"
import IdPage from "../views/Account/IdPage.vue"
import ProductRegisterPage from "../views/Product/ProductRegisterPage.vue"
import ProductDetailPage from "../views/Product/ProductDetailPage.vue"
import ProductRegister from "../components/Product/ProductRegister.vue"
import ProductDetail from "../components/Product/ProductDetail.vue"
import ProductCard from "../components/Product/ProductCard.vue"
import ProductCart from "../components/Product/ProductCart.vue"
import ProductPage from "../views/Product/ProductPage.vue"
import CartPage from "../views/Product/CartPage.vue"

import MemberModifyPage from "../views/Manager/MemberModifyPage"
import MemberReadPage from "../views/Manager/MemberReadPage"
import MemberListPage from "../views/Manager/MemberListPage"
import MainPage from "../views/MainPage.vue"

import TestPage from "../views/TestPage.vue"

Vue.use(VueRouter)

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch((err) => {
    if (err.name !== "NavigationDuplicated") throw err
  })
}

const routes = [
  {
    path: "/sign",
    name: "SignPage",
    component: SignPage,
  },
  {
    path: "/login",
    name: "LoginPage",
    component: LoginPage,
  },
  {
    path: "/password",
    name: "PasswordPage",
    component: PasswordPage,
  },
  {
    path: "/id",
    name: "IdPage",
    component: IdPage,
  },
  {
    path: "/productpage",
    name: "ProductPage",
    component: ProductPage,
  },
  {
    path: "/cart/",
    name: "CartPage",
    component: CartPage,
  },
  {
    path: "/main",
    name: "MainPage",
    component: MainPage,
  },

  {
    path: "/productdetail",
    name: "ProductDetail",
    component: ProductDetail,
  },
  {
    path: "/productcard",
    name: "ProductCard",
    component: ProductCard,
  },
  {
    path: "/productcart",
    name: "ProductCart",
    component: ProductCart,
  },

  {
    path: "/productdetailpage/:productId",
    name: "ProductDetailPage",
    components: {
      default: ProductDetailPage,
    },
    props: {
      default: true,
    },
  },
  {
    path: "/productregisterpage",
    name: "ProductRegisterPage",
    component: ProductRegisterPage,
  },
  {
    path: "/productregister",
    name: "ProductRegister",
    component: ProductRegister,
  },
  {
    path: "/memberlistpage",
    name: "MemberListPage",
    component: MemberListPage,
  },
  {
    path: "/membermodifypage/:memberNo",
    name: "MemberModifyPage",
    components: {
      default: MemberModifyPage,
    },
    props: {
      default: true,
    },
  },
  {
    path: "/memberreadpage/:memberNo",
    name: "MemberReadPage",
    components: {
      default: MemberReadPage,
    },
    props: {
      default: true,
    },
  },
  {
    path: "/test",
    name: "TestPage",
    component: TestPage,
  },
  {
    path: "/memberinfopage",
    name: "MemberInfoPage",
    component: MemberInfoPage,
  },
]

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
})

export default router
