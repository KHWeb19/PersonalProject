<template>
  <div>
    <div align="center">
    <br><br>
      <h1>로그인</h1>
      <!--v-icon대신할 이미지 필요함 -->
    </div>
    <login-form @submit="onSubmit"/>
  </div>
</template>

<script>
import LoginForm from '@/components/jpaMember/LoginForm.vue'
import axios from 'axios'
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
   name: "MemberLoginPage",
   components: {
      LoginForm
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
      onSubmit (payload) {
        if(!this.isLogin) {
          const { id, pw } = payload
          axios.post('http://localhost:7777/jpaMember/login', { id, pw }) //Spring Controller에 연동하여 전달
          .then(res => { //then 정상적으로 데이터를 받았을 경우 동작
            alert(' 로그인 성공! ' + res.data.userId)
              this.$store.state.userInfo = res.data
              this.$cookies.set("user", res.data, 60*60*12)// 12 시간
              //"토큰", "input_value", 만료 시간
              this.isLogin = true
              localStorage.setItem("userInfo", JSON.stringify(res.data))
              localStorage.getItem("userInfo")
            this.$router.push({ name: 'home' })              
          })
          .catch(res => { //에러 캐치한 경우 동작
            alert('로그인 실패!' + res.data)
          })
        } else {
          alert('이미 로그인되어 있습니다!')
        }
      },

    }
}
</script>

<style scoped>
h1{
  color: #907bb0;
}
</style>