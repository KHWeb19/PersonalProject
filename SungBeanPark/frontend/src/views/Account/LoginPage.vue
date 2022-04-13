<template>
  <login-page-form @submit="onSubmit"></login-page-form>
</template>
<script>
/* eslint-disable */
import LoginPageForm from "@/components/Account/LoginPageForm.vue"
import VueCookies from "vue-cookies"

import axios from "axios"
import Vue from "vue"

export default {
  name: "LoginPage",
  components: {
    LoginPageForm,
  },
  methods: {
    onSubmit(payload) {
      if (!this.isLogin) {
        const { id, pw } = payload
        axios
          .post("http://localhost:8888/Member/login", { id, pw })
          .then((res) => {
            if (res.data) {
              alert("로그인 성공!")
              this.$store.state.userInfo = res.data
              this.$router.push({ name: "MainPage" })
              this.isLogin = true
              window.localStorage.setItem("token", res.data.token)
              localStorage.setItem("userInfo", JSON.stringify(res.data))
            }
          })
          .catch((res) => {
            alert(res.response.data.message)
          })
      } else {
        alert("이미 로그인이 되어 있습니다!")
      }
    },
  },
}
</script>
<style scss scoped></style>
