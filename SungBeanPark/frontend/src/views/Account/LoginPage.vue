<template>
  <login-page-form></login-page-form>
</template>
<script>
/* eslint-disable */
import LoginPageForm from "@/components/Account/LoginPageForm.vue"
import Vue from "vue"
import axios from "axios"

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
              this.isLogin = true
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
