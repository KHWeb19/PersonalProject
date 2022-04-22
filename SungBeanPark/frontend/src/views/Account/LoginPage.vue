<template>
  <login-page-form @submit="onSubmit"></login-page-form>
</template>
<script>
import LoginPageForm from "@/components/Account/LoginPageForm.vue"
import cookies from "vue-cookies"
import axios from "axios"
import Vue from "vue"

Vue.use(cookies)
export default {
  name: "LoginPage",
  components: {
    LoginPageForm,
  },
  data() {
    return {
      isLogin: false,
    }
  },
  mounted() {
    this.$store.state.userInfo = this.$cookies.get("user")

    if (this.$store.state.userInfo != null) {
      this.isLogin = true
    } else {
      this.isLogin = false
    }
  },
  methods: {
    onSubmit(payload) {
      if (!this.isLogin) {
        const { id, pw } = payload
        axios
          .post("http://localhost:8888/Member/login", { id, pw })
          .then((res) => {
            if (res.data) {
              localStorage.setItem("member", JSON.stringify(res.data))
              this.$cookies.set("user", res.data, 300)
              this.$router.push({ name: "MainPage" })
              this.$store.state.userInfo = res.data
              this.isLogin = true
            } else {
              alert("아이디나 비밀번호가 틀립니다")
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
<style></style>
