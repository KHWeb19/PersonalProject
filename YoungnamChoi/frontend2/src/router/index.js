import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import LoginPage from "@/views/LoginPage.vue";
import SignUpPage from "@/views/SignUpPage.vue";
import BoardListPage from "@/views/BoardListPage.vue";
import BoardRegisterPage from "@/views/BoardRegisterPage.vue";
import BoardReadPage from "@/views/BoardReadPage.vue";
import BoardModifyPage from "@/views/BoardModifyPage.vue";
import Kakao from "@/views/Kakao.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/boardListPage",
    name: "BoardListPage",
    component: BoardListPage,
  },
  {
    path: "/boardRagisterPage",
    name: "BoardRegisterPage",
    component: BoardRegisterPage,
  },
  {
    path: "/board/:boardNo",
    name: "BoardReadPage",
    components: {
      default: BoardReadPage,
    },
    props: {
      default: true,
    },
  },
  {
    path: "/board/:boardNo/edit",
    name: "BoardModifyPage",
    components: {
      default: BoardModifyPage,
    },
    props: {
      default: true,
    },
  },

  {
    path: "/login",
    name: "LoginPage",
    component: LoginPage,
  },
  {
    path: "/signup",
    name: "SignUpPage",
    component: SignUpPage,
  },
  {
    path: "/searchpage",
    name: "Kakao",
    component: Kakao,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
