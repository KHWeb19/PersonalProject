<template>
  <div>
    <login-form @submit="onSubmit"/>
  </div>
</template>

<script>

import LoginForm from '@/components/jpaMember/LoginForm.vue'
import Vue from 'vue'
import axios from 'axios'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
  name: 'LoginPage.vue',
  components: {
    LoginForm
  },
  data () {
    return {
      isLogin: false
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
    onSubmit (payload) {
      if (!this.isLogin) {
        const {id, pw} = payload
        axios.post('http://localhost:7777/member/login', {id, pw})
            .then(res => {
              if (res.data) {
                alert('로그인 성공!')
                this.$store.state.userInfo = res.data
                this.$cookies.set("user", res.data, 30)
                this.isLogin = true
                // 로그인 성공시 DashBoardPage로 이동
                window.location.href = "DashBoardPage";
              }
            })
            .catch(res => {
              alert(res.response.data.message)
            })
      } else {
        alert('이미 로그인이 되어 있습니다!')
      }
    },
    logout () {
      this.$cookies.remove("user")
      this.isLogin = false
      this.$store.state.userInfo = null

      alert('로그아웃 성공!')
      window.location.href = "LoginPage";
    }
  }
}
</script>