import Vue from "vue"
import VueRouter from "vue-router"
import SignPage from "../views/SignPage.vue"
import LoginPage from "../views/LoginPage.vue"
import PasswordPage from "../views/PasswordPage.vue"
import IdPage from "../views/IdPage.vue"
import HeaderPage from "../views/HeaderPage.vue"

Vue.use(VueRouter)

const routes = [
  {
    path: "/sign",
    name: "sign",
    component: SignPage,
  },
  {
    path: "/login",
    name: "login",
    component: LoginPage,
  },
  {
    path: "/password",
    name: "password",
    component: PasswordPage,
  },
  {
    path: "/id",
    name: "id",
    component: IdPage,
  },
  {
    path: "/header",
    name: "header",
    component: HeaderPage,
  },
]

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
})

export default router
