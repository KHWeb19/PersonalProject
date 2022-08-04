<template>
  <div>
    <main-form/>
    <member-login @submit="onSubmit"></member-login>
    <main-bottom/>
  </div>
</template>

<script>
import MemberLogin from '@/components/member/MemberLogin.vue'
import Vue from 'vue'
import axios from 'axios'
import cookies from 'vue-cookies'
import MainForm from '@/components/main/MainForm.vue'
import MainBottom from '@/components/main/MainBottom.vue'

Vue.use(cookies)
Vue.$cookies.config("7d")

export default {
  name: "LoginPage.vue",
  components: {
    MemberLogin,
    MainForm,
    MainBottom
  },
  data () {
    return {
      isLogin: false
    }
  },
  mounted () {
    this.$store.state.userInfo = this.$cookies.get("user")
    if (this.$store.state.userInfo != null) {
      this.isLogin = true
    } else {
      this.isLogin = false
    }
  },
  methods: {
    onSubmit (payload) {
      if (!this.isLogin) {
        const { id, password } = payload
        axios.post('http://localhost:7777/member/login', { id, password })
          .then(res => {
            if (res.data) {
              this.$store.state.member = res.data
              this.$cookies.set("user", res.data)
              localStorage.setItem("userInfo", JSON.stringify(res.data))
              this.isLogin = true
              this.$router.push({
                name: 'MainPage'
              })
            } else {
              alert('ID와 비밀번호가 틀렸습니다.')
            }
          })
          .catch(res => {
            alert('로그인 실패')
          })
      } else {
        alert('이미 로그인이 되어 있습니다!')
      }
    },
    logout () {
      this.$cookies.remove("user")
      this.$store.state.userInfo = null
      alert('로그아웃 성공!')
    }
  }
}
</script>

<style scoped>
</style>
