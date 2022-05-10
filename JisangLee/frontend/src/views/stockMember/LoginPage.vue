<template>
  <div>
    <div align="center">
    </div>
    <login-form @submit="onSubmit"/>
  </div>
</template>

<script>
import swal from 'sweetalert';
import LoginForm from '@/components/stockMember/LoginForm.vue'
import Vue from 'vue'
import axios from 'axios'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
  name: "LoginPage.vue",
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
        const {id, pw, auth} = payload
        axios.post('http://localhost:7777/vueJpaMember/login', {id, pw, auth})
            .then(res => { 
              if (res.data) {
                swal({
                text: "로그인 되었습니다.",
                icon: "success"
                })
                this.$store.state.userInfo = res.data
                this.$cookies.set("user", res.data, 1200 )
                this.isLogin = true
                this.$router.push({
                  name: 'MainPage'
                })
              }
              else{
              swal({
                text: "아이디 또는 비밀번호를 잘못 입력하셨습니다.",
                icon:"warning"
                })
              }
            })
            .catch(() => {
              swal({
                text: "아이디 또는 비밀번호를 잘못 입력하셨습니다.",
                icon:"warning"
                })
            })
      } else {
        swal('이미 로그인이 되어 있습니다!')
      }
    }
  }
}

</script>

<style scoped>

</style>